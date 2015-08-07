DESCRIPTION = "C++ network programming framework that implements many core \
patterns for concurrent communication software"
SECTION = "net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d44c94111b5ebbca846989113d1528e8"

DEPENDS += "openssl gperf-native"

SRC_URI = "ftp://download.dre.vanderbilt.edu/previous_versions/ACE-${PV}.tar.bz2 \
           file://ARM_no_hidden_visibility.patch \
          "

S = "${WORKDIR}/ACE_wrappers"
PR = "r1"

LEAD_SONAME = "libACE-[0-9.]*.so"

inherit autotools

CXXFLAGS_append = " -fpermissive "
B = "${S}/build/linux.${TARGET_SYS}"

do_configure[noexec] = "1"

do_compile () {
     cd ${S}
     # create_ace_build requires build directory, and ${B}
     # cannot be given as create_ace_build won't take 
     # absolute paths. So referring to ${B} indirectly.
     ./bin/create_ace_build -v build/linux.${TARGET_SYS}

     # Build setup steps
     echo '#include "ace/config-linux.h"' > ${B}/ace/config.h
     echo 'include $(ACE_ROOT)/include/makeinclude/platform_linux.GNU' >> \
     ${B}/include/makeinclude/platform_macros.GNU

     # Start build
     cd ${B}
     export ACE_ROOT="$PWD"
     oe_runmake CROSS_COMPILE="${TARGET_PREFIX}"
}

do_install () {
     # Start install
     export ACE_ROOT="$PWD"
     oe_runmake CROSS_COMPILE="${TARGET_PREFIX}" \
     DESTDIR="${D}" INSTALL_PREFIX="${prefix}" \
     INSTALL_LIB="${baselib}" install
}

PACKAGES =+ "lib${BPN} lib${BPN}-dev"
FILES_lib${BPN} += "${libdir}/lib*${PV}*so"
FILES_lib${BPN}-dev = "${libdir}/lib*${SOLIBSDEV} \
                       ${libdir}/*.la ${includedir} \
                       ${libdir}/pkgconfig"

RDEPENDS_${PN} += "perl"

SRC_URI[md5sum] = "aa8dd39c2a6e4de755062b55aebff3e2"
SRC_URI[sha256sum] = "d8e5ad92eab743936fb8921301e7df09a4d331270be2b7b3dec7f47b8ba2ce5f"

