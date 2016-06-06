SRCREV = "aec68ab217fd2956443b27ceeb97dd6475267789"
LIC_FILES_CHKSUM = "file://COPYING;md5=b06690e7a95c166eefe0199b39118eb1"

PV = "0.5.0+git${@'${SRCPV}'.split('+')[-1]}"
PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://remove_check_for_systemd_using_systemctl_command.patch"

DEPENDS_append  = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " systemd", "", d)}"

# From jethro onwards, the least version of systemd is 225 
CC_append  = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " -DSYSTEMD=225 ", "", d)}"
FILES_kpartx += "/lib/udev"
