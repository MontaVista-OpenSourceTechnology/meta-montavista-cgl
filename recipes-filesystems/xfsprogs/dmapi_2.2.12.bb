DESCRIPTION = "library functions to get attribute bits"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPLv2"
LICENSE_libhandle = "LGPLv2.1"
SECTION = "base"
LIC_FILES_CHKSUM = "file://doc/COPYING;md5=1678edfe8de9be9564d23761ae2fa794"
DEPENDS = "gettext xfsprogs"
PR = "r2"


SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/dmapi-${PV}.tar.gz \
	   file://remove-install-as-user.patch \
           file://dmapi_aarch64_configure_support.patch \
          "
SRC_URI[md5sum] = "cd825d4e141c16011367e0a0dd98c9c5"
SRC_URI[sha256sum] = "b18e34f47374f6adf7c164993c26df36986a009b86aa004ef9444102653aea69"

inherit autotools

do_configure[noexec] = "1"
B = "${S}"

PARALLEL_MAKE = ""
EXTRA_OECONF += "--enable-gettext=no"
TARGET_CC_ARCH += "${LDFLAGS}"

LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "LOCAL_CONFIGURE_OPTIONS="--host=${HOST_SYS} --target=${TARGET_SYS}" \
                V=1"

do_install () {
    export DIST_ROOT=${D}
    install -d ${D}${libdir}
    oe_runmake install install-dev PKG_DEVLIB_DIR=${libdir}
}
