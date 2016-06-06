PR .= ".1"
FILES_${PN} += "/usr/lib/ocf"
EXTRA_OEMAKE += "pyexecdir='${libdir}/python${PYTHON_BASEVERSION}/site-packages/' pythondir='${libdir}/python${PYTHON_BASEVERSION}/site-packages/'"

# Deal with problem with external ranlib being 32bit on a 64bit machine.
do_install_append () {
   chown root.root ${D}/${libdir}/*.a
}
