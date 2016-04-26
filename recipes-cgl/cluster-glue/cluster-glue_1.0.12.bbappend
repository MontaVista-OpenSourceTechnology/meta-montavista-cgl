PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "libgcrypt"

do_install_append () {
    sed -i -e '1s,#!.*python,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}
