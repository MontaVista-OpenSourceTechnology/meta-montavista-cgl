PR .= ".4"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += "libgcrypt"

do_install:append () {
    sed -i -e '1s,#!.*PYTHON.*,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}

inherit multilib_script multilib_header
MULTILIB_SCRIPTS = "${PN}:${sbindir}/cibsecret ${PN}:${sbindir}/hb_report"

do_install:append () {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','false','true',d)}; then
        mv ${D}${sysconfdir}/init.d/logd ${D}${sysconfdir}/init.d/logd.${PN}
    fi
    oe_multilib_header heartbeat/glue_config.h
}

#FIXME add postinstalls
FILES:${PN} += "${sysconfdir}/init.d/logd.${PN}"
