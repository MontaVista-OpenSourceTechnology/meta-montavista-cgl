DESCRIPTION = "Live Application Dump userspace tool"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
PR = "r1"

SRC_URI = "git://github.com/MontaVista-OpenSourceTechnology/linux-live-app-coredump-userland.git"
SRCREV="v0.2.0"

inherit autotools autotools
S="${WORKDIR}/git"
