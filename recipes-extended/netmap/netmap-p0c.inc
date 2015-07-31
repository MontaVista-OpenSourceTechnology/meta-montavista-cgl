SECTION = "devel"
SUMMARY = "netmap kernel modules"
DESCRIPTION = "The fast packet I/O framework"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README;md5=998eaad7db2c27b04f63f07bab2bcb35"

DEPENDS = "virtual/kernel"

inherit module

export INSTALL_MOD_DIR="kernel/netmap-modules"

S = "${WORKDIR}/netmap-release"
B = "${S}/LINUX"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	cd ${S}/LINUX
	make KSRC="${STAGING_KERNEL_DIR}" \
			DRIVERS=xgene/ XGENE_STANDALONE=1
}

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/${INSTALL_MOD_DIR}
	install -m 644 netmap_lin.ko ${D}/lib/modules/${KERNEL_VERSION}/${INSTALL_MOD_DIR}
	install -m 644 xgene/xgene-netmap.ko ${D}/lib/modules/${KERNEL_VERSION}/${INSTALL_MOD_DIR}
}
