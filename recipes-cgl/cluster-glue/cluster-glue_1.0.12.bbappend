PR .= ".1"

do_install_append () {
    sed -i -e '1s,#!.*python,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}
