PACKAGECONFIG_pn-qemu ?= " fdt virtfs libcap-ng "
DISTRO_FEATURES_append += "openstack"

BBMASK += "meta-openstack/recipes-support/openldap/openldap_2.4.39.bbappend"
BBMASK += "meta-cgl-common/recipes-cgl/openais/openais_1.1.4.bb"
# Get rid of older bbappend files
BBMASK += "meta-cgl-common/recipes-core/packagegroups/packagegroup-cgl-applications.bb"
BBMASK += "meta-cgl-common/recipes-core/images/core-image-cgl.bb"
BBMASK += "meta-openstack/recipes-extended/iptables/iptables_1.4.21.bbappend"
BBMASK += "meta-openstack/recipes-devtools/qemu/qemu_2.%.bbappend"
BBMASK += "meta-openstack/recipes-kernel/linux/linux-yocto_4.12.bbappend"
BBMASK += "meta-openstack/recipes-support/bash-completion/bash-completion_2.1.bbappend"
BBMASK += "meta-openstack/recipes-support/libbsd/libbsd_0.7.0.bbappend"
BBMASK += "meta-openstack/recipes-graphics/xorg-app/xterm_320.bbappend"
BBMASK += "meta-cgl-common/images/core-image-cgl-initramfs.bb"

