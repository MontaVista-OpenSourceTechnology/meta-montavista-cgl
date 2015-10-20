PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://remove_--relative-option-in-ln-command.patch"

DEPENDS += "flex-native"
