PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://use_hostname_alone.patch"

# opensaf provides same functionality as openais
PROVIDES += "openais"
RPROVIDES_${PN} += "openais"
RPROVIDES_${PN}-dev += "openais-dev"
RPROVIDES_${PN}-staticdev += "openais-staticdev"
RPROVIDES_${PN}-doc += "openais-doc"
RPROVIDES_${PN}-locale += "openais-locale"
RPROVIDES_${PN}-dbg += "openais-dbg"
