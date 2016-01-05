PR .= ".1"

do_install_append () {
    rm -rf ${D}${localstatedir}/lock
}
