PR = "${INC_PR}.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/openipmi/OpenIPMI-${PV}.tar.gz \
           file://makefile.patch \
           file://makefile_glib.patch \
           file://makefile_cmdlang.patch \
           file://makefile_tcl.patch \
          "
SRC_URI[md5sum] = "dc0b42ae40b3f1d0db2a94b75b95fae1"
SRC_URI[sha256sum] = "37b844d02119b94b31e2bb2bd8062ffdf6cd3eb4bc75fa6c47184e8b14fe95b8"

require openipmi.inc
