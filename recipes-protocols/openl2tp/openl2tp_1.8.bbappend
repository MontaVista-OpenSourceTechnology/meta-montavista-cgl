PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fix_to_compile_with_more_jobs.patch"
