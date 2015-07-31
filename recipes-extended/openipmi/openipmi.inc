DESCRIPTION = "This is the OpenIPMI library, a library that makes simplifies building complex IPMI management software."
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = " \
    openssl \
    popt \
    zlib \
    ncurses \
    glib-2.0 \
    gdbm \
    "

INC_PR = "r2"

inherit autotools gettext update-alternatives

PACKAGECONFIG ??= "net-snmp"

PACKAGECONFIG[net-snmp] = ",--with-ucdsnmp=no,net-snmp"
PACKAGECONFIG[python] = "--with-python,--without-python,python,"
PACKAGECONFIG[perl] = "--with-perl=${STAGING_BINDIR_NATIVE},--with-perl=no,perl,"
PACKAGECONFIG[tcl] = "--with-tcl,--without-tcl,tcl,"

EXTRA_OECONF = "\
    --prefix=${prefix} \
    "

S = "${WORKDIR}/OpenIPMI-${PV}"

PARALLEL_MAKEINST = ""

FILES_${PN} += "/usr/lib/perl5"
FILES_${PN}-dbg += "/usr/lib/perl5/auto/OpenIPMI/.debug"
