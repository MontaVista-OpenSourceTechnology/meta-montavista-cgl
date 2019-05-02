PR .= ".1"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fix-undefined-reference-to-major.patch"

DEPENDS += "libaio"
