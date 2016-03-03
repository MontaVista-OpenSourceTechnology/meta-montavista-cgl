DESCRIPTION = "C++ network programming framework that implements many core \
patterns for concurrent communication software"
SECTION = "net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=53c90cae768076db629195780e465e16"

DEPENDS += "openssl gperf-native"

SRC_URI = "ftp://download.dre.vanderbilt.edu/previous_versions/ACE-${PV}.tar.bz2 \
           file://ARM_visibility_plus_librt_fix.patch \
           file://disable_gperf_tests.patch \
           file://use_sslv23_method.patch \
          "

S = "${WORKDIR}/ACE_wrappers"

PR = "r0"

EXTRA_OECONF += "--enable-ace-tests"
LEAD_SONAME = "libACE-[0-9.]*.so"

inherit autotools

CXXFLAGS_append = " -fpermissive "

B = "${WORKDIR}/build.${TARGET_SYS}"

do_configure_prepend() {
    export ace_cv_linux_event_poll=yes
}

do_compile_append () {
    export STAGING_DIR_TARGET="${STAGING_DIR_TARGET}"
}

do_install_append () {
    install -d -m 0755 ${D}/usr/include/ace
    cp -af ${WORKDIR}/ACE_wrappers/ace/Obstack.h ${D}/usr/include/ace
}

PACKAGES =+ "lib${BPN} lib${BPN}-dev"
FILES_lib${BPN} += "${libdir}/lib*${PV}*so"
FILES_lib${BPN}-dev = "${libdir}/lib*${SOLIBSDEV} \
                       ${libdir}/*.la ${includedir} \
                       ${libdir}/pkgconfig"

SRC_URI[md5sum] = "0c9c30bc0ce46017f21518f0dc24cc58"
SRC_URI[sha256sum] = "2ea07c62d9ac78ce828c182a7aa9e426bb6367765c9e06b5f7fe2043e8498768"

