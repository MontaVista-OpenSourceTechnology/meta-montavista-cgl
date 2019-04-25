addhandler mmcgl_bbappend_distrocheck
mmcgl_bbappend_distrocheck[eventmask] = "bb.event.SanityCheck"
python mmcgl_bbappend_distrocheck() {
    skip_check = e.data.getVar('SKIP_META_MONTAVISTA_CGL_SANITY_CHECK') == "1"
    if 'mvista-cgl' not in e.data.getVar('DISTRO_FEATURES').split() and not skip_check:
        bb.warn("You have included the meta-montavista-cgl layer, but \
'mvista-cgl' has not been enabled in your DISTRO_FEATURES. Some bbappend files \
and preferred version setting may not take effect. See the meta-montavista-cgl README \
for details on enabling montavista cgl support.")
}

require ${@bb.utils.contains('DISTRO_FEATURES', 'mvista-cgl', 'conf/mvista-cgl-default-versions.inc', '', d)}
