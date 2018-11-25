PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://use_hostname_alone.patch"
SRC_URI += "file://opensaf-ilp32.diff"

# opensaf provides same functionality as openais
PROVIDES += "openais"
RPROVIDES_${PN} += "openais"
RPROVIDES_${PN}-dev += "openais-dev"
RPROVIDES_${PN}-staticdev += "openais-staticdev"
RPROVIDES_${PN}-doc += "openais-doc"
RPROVIDES_${PN}-locale += "openais-locale"
RPROVIDES_${PN}-dbg += "openais-dbg"

inherit multilib_script
MULTILIB_SCRIPTS = "${PN}:${sysconfdir}/opensaf/nodeinit.conf.controller \
                    ${PN}:${sysconfdir}/opensaf/nodeinit.conf.payload \
                    ${PN}:${sysconfdir}/opensaf/osafdir.conf \
                    ${PN}:${datadir}/opensaf/immxml/services/common_pl_template.xml \
                    ${PN}:${datadir}/opensaf/immxml/services/common_sc_template.xml \
                    ${PN}:${datadir}/opensaf/immxml/services/smfsv_objects.xml"
