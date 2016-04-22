
SUMMARY = "Additional packages for cgl profile"
DESCRIPTION = "Additional packages for cgl profile"
PR = "r1"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
         packagegroup-profile-cgl \
"

MKRAMDISK='${@base_contains("IMAGE_FEATURES", "busyboxless", "", "mvmkramdisk", d)}'
EXTRA_X86 = ""
EXTRA_X86_x86-64 = "${MKRAMDISK}"
EXTRA_X86_i686 = "${MKRAMDISK}"


RDEPENDS_packagegroup-profile-cgl = " \
         packagegroup-additional-oe-tools \
         packagegroup-core-full-cmdline \
         packagegroup-core-lsb-core \
         packagegroup-core-tools-testapps \
         packagegroup-core-tools-debug \
         packagegroup-core-buildessential \
         packagegroup-self-hosted \
         packagegroup-cge-utilities \
         packagegroup-additional-oe-tools-cgl \
         ${EXTRA_X86} \
" 
