PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append_class-native = " \
                               file://use_%a_instead_of_%m_in_sscanf.patch \
                              "
