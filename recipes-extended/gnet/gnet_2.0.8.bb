DESCRIPTION = "GNet is a simple network library. It is written in C, object-oriented, and built upon GLib."
SECTION = "libs/network"
HOMEPAGE = "http://www.gnetlibrary.org"
DEPENDS = "glib-2.0 libcheck"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=3dd751ebf11428ec1875fe5cd212d069"
PR = "r2"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gnet/2.0/gnet-${PV}.tar.bz2 \
           file://buildfix.patch \
           file://configure_fix.patch \
           file://pkgconfig_fix.patch \
           file://gnet_2.0.8-2.2ubuntu1.diff;apply=yes "

EXTRA_OECONF +=	"--disable-pthreads"

FILES_${PN}-dev += "${libdir}/gnet-2.0"

inherit autotools pkgconfig

SRC_URI[md5sum] = "93327d2fca333d7e54ba2cf54e071165"
SRC_URI[sha256sum] = "14034c7ef571a93f2aca21b2280fa86b35ef5730541d3eb57557dd42d7cc506b"

