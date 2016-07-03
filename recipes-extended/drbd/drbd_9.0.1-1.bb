DESCRIPTION = "DRBD is a block device which is designed to build high \
               availability clusters. This is done by mirroring a whole \
               block device via (a dedicated) network. You could see \
               it as a network raid-1."
HOMEPAGE = "http://oss.linbit.com/drbd/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5574c6965ae5f583e55880e397fbb018"
DEPENDS = "virtual/kernel"

SRC_URI = "http://oss.linbit.com/drbd/9.0/drbd-${PV}.tar.gz \
           file://check_existing_of_modules_before_installing.patch"

SRC_URI[md5sum] = "0d1d50e225ee0c8058af4fe1442d5242"
SRC_URI[sha256sum] = "f0862fffa5d73c433598fe1957bab61a2ae7ae1c4c7c0cecbef760e67a65fe20"

inherit module-base

# Add make_scripts task to create kernel scripts
addtask make_scripts after do_patch before do_compile

do_configure[noexec] = "1"

# make_scripts requires kernel source directory to create
# kernel scripts
do_make_scripts[depends] += "virtual/kernel:do_shared_workdir"

# Make sure we don't have race condition against "make scripts"
do_make_scripts[lockfiles] = "${TMPDIR}/kernel-scripts.lock"

do_compile() {
    oe_runmake KDIR=${STAGING_KERNEL_DIR} CFLAGS='${CFLAGS}' LDFLAGS='' \
    CC="${CC}" V=1
}

do_install () {
    oe_runmake install DESTDIR="${D}"
}

FILES_${PN} += "/lib"
RDEPENDS_${PN} += "drbd-utils"
