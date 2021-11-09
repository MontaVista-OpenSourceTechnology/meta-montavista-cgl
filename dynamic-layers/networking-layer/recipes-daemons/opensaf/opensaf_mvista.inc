PR .= ".3"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://use_hostname_alone.patch"

# opensaf provides same functionality as openais
PROVIDES += "openais"
RPROVIDES:${PN} += "openais"
RPROVIDES:${PN}-dev += "openais-dev"
RPROVIDES:${PN}-staticdev += "openais-staticdev"
RPROVIDES:${PN}-doc += "openais-doc"
RPROVIDES:${PN}-locale += "openais-locale"
RPROVIDES:${PN}-dbg += "openais-dbg"

inherit multilib_script
MULTILIB_SCRIPTS = "${PN}:${sysconfdir}/opensaf/nodeinit.conf.controller \
                    ${PN}:${sysconfdir}/opensaf/nodeinit.conf.payload \
                    ${PN}:${sysconfdir}/opensaf/osafdir.conf \
                    ${PN}:${datadir}/opensaf/immxml/services/common_pl_template.xml \
                    ${PN}:${datadir}/opensaf/immxml/services/common_sc_template.xml \
                    ${PN}:${datadir}/opensaf/immxml/services/smfsv_objects.xml"
