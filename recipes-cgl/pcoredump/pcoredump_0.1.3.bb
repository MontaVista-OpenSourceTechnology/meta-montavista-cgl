DESCRIPTION = "Live Application Dump userspace tool"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
PR = "r1"

SRC_URI = "${MVL_MIRROR}/pcoredump-${PV}.tar.bz2"

inherit autotools autotools_stage

SRC_URI[md5sum] = "072484ae4ff4423c45f2cf37db91523e"
SRC_URI[sha256sum] = "ecf14b67e5f1a5a1c87313ec04c0c4702544ab7c38a4a424973cefe4dafb8a31"

