DESCRIPTION = "SNMP library written on top of glib and gnet."
SECTION = "libs/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "glib-2.0 gnet"
PR = "r1"

SRC_URI = "ftp://ftp.cn.debian.org/gentoo/distfiles/gsnmp-${PV}.tar.gz \
	   file://quote-fix.patch"

SRC_URI[md5sum] = "466699c11b70e18a04d51388b8f89f1c"
SRC_URI[sha256sum] = "e428b61071b8ba2971fc8737ed2987210b04a71ffde307900df12c06a0bed0f9"

inherit autotools pkgconfig
