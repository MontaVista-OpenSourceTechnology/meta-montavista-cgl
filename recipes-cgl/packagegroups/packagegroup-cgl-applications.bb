#Copied from meta-cgl to fix problems with the RDEPENDS:${PN} warning messages.

SUMMARY = "Application packages required to satisfy the Carrier Grade Linux (CGL) specification"
DESCRIPTION = "This package group includes the application with which the user interacts \
               when using a Linux operation system."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup
inherit pkgconfig


PACKAGES = "packagegroup-cgl-applications"

GDBSERVER = "gdbserver"
GDBSERVER:riscv64 = ""
RDEPENDS:packagegroup-cgl-applications = " \
    bc \
    gettext \
    gettext-runtime \
    babeltrace \
    gdb \
    ${GDBSERVER} \
    rsync \
    strace \
    libevent \
    mdadm \
    quota \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)} \
"

LTTNG ?= "\
    lttng-tools \
    lttng-ust \
    "
#FIXME Currently does not build against 4.14.
#
#    lttng-modules 
LTTNG:armv6 ?= ""

LTTNGUST = "lttng-ust"
LTTNGUST_libc-uclibc = ""

RDEPENDS:packagegroup-cgl-applications:append:qemux86 = " valgrind lttng-ust"
RDEPENDS:packagegroup-cgl-applications:append:qemux86-64 = " ${LTTNGUST}"
RDEPENDS:packagegroup-cgl-applications:append:qemuppc = " ${LTTNGUST}"
RDEPENDS:packagegroup-cgl-applications:append:qemuarm = " ${LTTNGUST}"
RDEPENDS:packagegroup-cgl-applications:append:powerpc = " ${LTTNGUST}"

RRECOMMENDS:packagegroup-cgl-applications = ""
