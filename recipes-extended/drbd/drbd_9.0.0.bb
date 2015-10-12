DESCRIPTION = "DRBD is a block device which is designed to build high \
               availability clusters. This is done by mirroring a whole \
               block device via (a dedicated) network. You could see \
               it as a network raid-1."
HOMEPAGE = "http://oss.linbit.com/drbd/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5574c6965ae5f583e55880e397fbb018"
DEPENDS = "virtual/kernel"

SRC_URI = "http://oss.linbit.com/drbd/9.0/drbd-${PV}.tar.gz"

SRC_URI[md5sum] = "62706c1b57bf399071272dad0d267421"
SRC_URI[sha256sum] = "0dc6e37492dcc8a960311b3b0b7e2d17bd1afff146756cdd80d5477c17d7dffc"

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
