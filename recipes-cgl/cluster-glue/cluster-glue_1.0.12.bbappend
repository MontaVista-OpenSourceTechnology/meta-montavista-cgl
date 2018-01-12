PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "libgcrypt"

do_install_append () {
    sed -i -e '1s,#!.*python,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}

inherit multilib-alternatives
MULTILIB_HEADERS = "heartbeat/glue_config.h"

do_install_append () {
     mv ${D}${sysconfdir}/init.d/logd ${D}${sysconfdir}/init.d/logd.${PN}
}

#FIXME add postinstalls
FILES_${PN} += "${sysconfdir}/init.d/logd.${PN}"
