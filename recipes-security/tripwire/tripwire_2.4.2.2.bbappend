PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://Fix-Fatal-exception-std-exception-errors.patch \
            file://add_armeb_arch.patch \
           "
