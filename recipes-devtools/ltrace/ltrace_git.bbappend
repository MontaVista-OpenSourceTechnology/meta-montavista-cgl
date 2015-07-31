PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://check_system_call_trap_for_armeb.patch"
