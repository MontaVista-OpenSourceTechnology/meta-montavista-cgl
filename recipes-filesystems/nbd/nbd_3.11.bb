DESCRIPTION = "Network Block Device"
HOMEPAGE = "http://nbd.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://depcomp;beginline=6;endline=26;md5=3a3627e6495e2ff2a3316bcdaad91e9c"
PR="r0"
DEPENDS = "glib-2.0"
SECTION = "base"

SRC_URI = "${SOURCEFORGE_MIRROR}/nbd/nbd/${PV}/nbd-${PV}.tar.xz"
SRC_URI[md5sum] = "73d11644a28b9f335292cdb3bdc4b74b"
SRC_URI[sha256sum] = "14420f74cb16dc609a9302ed1efd653064bed7a8357e9d73daabc33608e3f2a0"

inherit autotools pkgconfig

PACKAGES = "nbd-client nbd-server nbd-client-dbg nbd-server-dbg nbd-trdump \
            nbd-trdump-dbg nbd-client-doc nbd-server-doc "

FILES_nbd-client = "${sbindir}/nbd-client"
FILES_nbd-server = "${bindir}/nbd-server"
FILES_nbd-trdump = "${bindir}/nbd-trdump"
FILES_nbd-client-dbg += " \
                     ${sbindir}/.debug/nbd-client \
                     ${prefix}/src/debug/${PN}/${PV}-${PR}/${BP}/nbd-client.c"
FILES_nbd-server-dbg += " \
                       ${bindir}/.debug/nbd-server \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${BP}/nbd.h \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${BP}/cliserv.h \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${BP}/nbd-server.c \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${PN}-${PV}/nbdsrv.h \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${PN}-${PV}/cliserv.c \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${PN}-${PV}/nbdsrv.c \
                       "
FILES_nbd-trdump-dbg += " \
                       ${bindir}/.debug/nbd-trdump \
                       ${prefix}/src/debug/${PN}/${PV}-${PR}/${BP}/nbd-trdump.c"
FILES_nbd-client-doc = "${mandir}/man8/*"
FILES_nbd-server-doc = "${mandir}/man1/* \
                        ${mandir}/man5/*"
