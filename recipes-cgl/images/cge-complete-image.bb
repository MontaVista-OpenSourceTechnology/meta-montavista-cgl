require recipes-core/images/core-image-base.bb

#require devel-image.bb

export IMAGE_BASENAME = "cge-complete-image"

EXTRA_IMAGE_FEATURES += "dbg-pkgs dev-pkgs staticdev-pkgs"
MKRAMDISK='${@bb.utils.contains("IMAGE_FEATURES", "busyboxless", "", "mvmkramdisk", d)}'
EXTRA_X86 = ""
EXTRA_X86_x86-64 = "${MKRAMDISK}"
EXTRA_X86_i686 = "${MKRAMDISK}"

IMAGE_INSTALL += "packagegroup-core-full-cmdline"
IMAGE_INSTALL += "packagegroup-core-lsb-core" 
IMAGE_INSTALL += "packagegroup-core-tools-profile"
IMAGE_INSTALL += "packagegroup-core-tools-testapps"
IMAGE_INSTALL += "packagegroup-core-tools-debug"
IMAGE_INSTALL += "packagegroup-core-buildessential"
IMAGE_INSTALL += "packagegroup-self-hosted"
IMAGE_INSTALL += "packagegroup-cge-utilities"
IMAGE_INSTALL += "packagegroup-additional-oe-tools"
IMAGE_INSTALL += "packagegroup-additional-oe-tools-cgl"
IMAGE_INSTALL += "${EXTRA_X86}"

