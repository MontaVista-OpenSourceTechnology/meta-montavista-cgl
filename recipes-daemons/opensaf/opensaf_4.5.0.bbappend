PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://sed-follow-links.patch \
	    file://use_hostname_alone.patch \
           "
