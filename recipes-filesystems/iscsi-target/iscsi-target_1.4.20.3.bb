DESCRIPTION = "iSCSI Enterprise Target is for building an \
iSCSI storage system on Linux"
HOMEPAGE = "http://iscsitarget.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e233eda45c807aa29aeaa6d94bc48a2"
DEPENDS = "openssl virtual/kernel"
RRECOMMENDS_${PN} = "kernel-module-crc32c kernel-module-libcrc32c"
PR = "r0"

SRC_URI = "http://ftp.heanet.ie/mirrors/ubuntu/pool/universe/i/iscsitarget/iscsitarget_${PV}+svn502.orig.tar.gz \
           file://use-makefile-to-get-kernel-version.patch \
	  "

SRC_URI[md5sum] = "ef9bc823bbabd3c772208c00d5f2d089"
SRC_URI[sha256sum] = "d3196ccb78a43266dce28587bfe30d8ab4db7566d7bce96057dfbb84100babb5"

S = "${WORKDIR}/iscsitarget-${PV}+svn502"

inherit module-base
addtask make_scripts after do_patch before do_compile

do_configure[noexec] = "1"
do_make_scripts[depends] += "virtual/kernel:do_shared_workdir"

do_compile() {
    oe_runmake KSRC=${STAGING_KERNEL_DIR} CFLAGS='${CFLAGS}' LDFLAGS='' \
    CC="${CC}" V=1
}

do_install() {
    # Module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/iscsi
    install -m 0644 kernel/iscsi_trgt.ko \
    ${D}/lib/modules/${KERNEL_VERSION}/kernel/iscsi/iscsi_trgt.ko
    
    # Userspace utilities
    install -d ${D}${sbindir}
    install -m 0755 usr/ietd ${D}${sbindir}/ietd
    install -m 0755 usr/ietadm ${D}${sbindir}/ietadm
    
    # Config files, init scripts
    mkdir -p ${D}${sysconfdir}/iet
    install -m 0644 etc/ietd.conf ${D}/${sysconfdir}/iet/ietd.conf
    install -m 0644 etc/initiators.allow ${D}${sysconfdir}/iet/initiators.allow
    install -m 0644 etc/targets.allow ${D}${sysconfdir}/iet/targets.allow
    mkdir -p ${D}${sysconfdir}/init.d
    install -m 0755 etc/initd/initd ${D}${sysconfdir}/init.d/iscsi-target
    install -m 0644 etc/initiators.deny ${D}${sysconfdir}/iet/initiators.deny
}

QAPATHTEST[arch] = ""
modules_lib_dir = "/lib"
FILES_${PN} += "${sbindir} \
                ${modules_lib_dir} \
                ${sysconfdir}"
