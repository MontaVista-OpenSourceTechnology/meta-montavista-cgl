DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, \
and FISH."
SECTION = "console/network"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r0"

DEPENDS = "readline gnutls"

SRC_URI = "http://fossies.org/linux/misc/lftp-${PV}.tar.gz \
          "
SRC_URI[md5sum] = "2777dd514d21fe1da764bedd1d0ab36c"
SRC_URI[sha256sum] = "a8b53e5ca2c1acbecd181c87f21a8673ca9038dc9f2be6ab8c23790bd91fd446"

inherit autotools gettext pkgconfig

EXTRA_OECONF += "--with-modules"

PACKAGECONFIG ??= "libidn"
PACKAGECONFIG[libidn] = "--with-libidn=yes,--with-libidn=no,libidn"

FILES_${PN}-dbg += "${libdir}/lftp/${PV}/.debug"
RDEPENDS_${PN} = "perl bash"
