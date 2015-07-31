DESCRIPTION = "XFS Filesystem Dump Utility"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPLv2"
LICENSE_libhandle = "LGPLv2.1"
SECTION = "base"
LIC_FILES_CHKSUM = "file://doc/COPYING;md5=15c832894d10ddd00dfcf57bee490ecc"
DEPENDS = "xfsprogs attr"
PR = "r2"


SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/${BPN}-${PV}.tar.gz \
	   file://remove-install-as-user.patch \
           file://define_min_max.patch \
          "

SRC_URI[md5sum] = "a8b1761be5feb363131e7b506639ad4c"
SRC_URI[sha256sum] = "570eafd0721515bdd79cb0e295b701d49cdf81e71a0a0ff0df6d4c5cc1960943"

inherit autotools

B = "${S}"

PARALLEL_MAKE = ""
EXTRA_OECONF += "--enable-gettext=no"

LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}' V=1"

do_configure () {
    export DEBUG="-DNDEBUG"
    oe_runconf
}

do_install () {
    export DIST_ROOT=${D}
    oe_runmake install 
    oe_runmake install-dev
}
