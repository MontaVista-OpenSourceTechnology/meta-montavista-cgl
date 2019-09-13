
SUMMARY = "Additional packages for cgl profile"
DESCRIPTION = "Additional packages for cgl profile"
PR = "r1"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
         packagegroup-profile-cgl \
"

MKRAMDISK='${@bb.utils.contains("IMAGE_FEATURES", "busyboxless", "", "mvmkramdisk", d)}'
EXTRA_X86 = ""
EXTRA_X86_x86-64 = "${MKRAMDISK}"
EXTRA_X86_i686 = "${MKRAMDISK}"


RDEPENDS_packagegroup-profile-cgl = " \
         packagegroup-additional-oe-tools \
         packagegroup-core-full-cmdline \
         packagegroup-core-tools-testapps \
         packagegroup-core-tools-debug \
         packagegroup-core-buildessential \
         packagegroup-self-hosted \
         packagegroup-cge-utilities \
         packagegroup-additional-oe-tools-cgl \
         ${EXTRA_X86} \
" 
# LSB moved out of openembeeded-core.
#         ${@bb.utils.contains('DISTRO_FEATURES', 'pam opengl x11', 'packagegroup-core-lsb-core', '', d)} 
