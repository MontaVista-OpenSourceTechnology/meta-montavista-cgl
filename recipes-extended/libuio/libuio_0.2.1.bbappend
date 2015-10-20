PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://replace_inline_with_static-inline.patch"
PNBLACKLIST[libuio] = ""
