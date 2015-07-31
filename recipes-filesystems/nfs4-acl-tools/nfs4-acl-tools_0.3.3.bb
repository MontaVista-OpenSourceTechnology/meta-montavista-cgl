DESCRIPTION = "This package contains commandline utilities for the Linux NFSv4 client"
HOMEPAGE = "http://www.citi.umich.edu/projects/nfsv4/linux"
LICENSE = "University & of & Michigan & (LGPLv2 & GPLv2)"
LIC_FILES_CHKSUM = "file://COPYING;md5=44cb16b9de1b3686b623a720dab4c898"

DEPENDS = "attr"
SRC_URI = "http://www.citi.umich.edu/projects/nfsv4/linux/nfs4-acl-tools/nfs4-acl-tools-0.3.3.tar.gz \
          "
PR = "r1"

SRC_URI[md5sum] = "ece4d5599c3b8470990ee1adbe22e047"
SRC_URI[sha256sum] = "1990cf5664ff1258695d5f15100b352912366ea2db2c661941adf053bbe966b4"

inherit autotools
B = "${S}"

do_configure () {
    autoconf
    oe_runconf
}
EXTRA_OECONF += "ac_cv_path_LIBTOOL="${HOST_SYS}-libtool""

