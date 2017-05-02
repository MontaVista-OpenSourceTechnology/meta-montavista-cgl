DESCRIPTION = "Live Application Dump userspace tool"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
PR = "r1"

SRC_URI = "${MVL_MIRROR}/pcoredump-${PV}.tar.gz"

inherit autotools autotools

SRC_URI[md5sum] = "87e676f60b9d3d83e4033acf78fc37fb"
SRC_URI[sha256sum] = "3ae70e34037081d2c6fe556a502bef4134bd49e11b44d9cc667f4766f8a2ae5a"

