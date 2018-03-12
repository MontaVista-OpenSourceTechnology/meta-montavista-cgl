PR .= ".4"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "libgcrypt"

do_install_append () {
    sed -i -e '1s,#!.*python,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}

inherit multilib-alternatives
MULTILIB_HEADERS = "heartbeat/glue_config.h"

do_install_append () {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','false','true',d)}; then
        mv ${D}${sysconfdir}/init.d/logd ${D}${sysconfdir}/init.d/logd.${PN}
    fi
}

#FIXME add postinstalls
FILES_${PN} += "${sysconfdir}/init.d/logd.${PN}"
