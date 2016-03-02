PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://fix-install-paths.patch \
            file://samhain_test_9.patch \
            file://donot-include-host-sys-flags.patch"

EXTRA_OECONF += "--with-config-file=REQ_FROM_SERVER/etc/yulerc"

PACKAGECONFIG ??= "postgresql suidcheck logwatch userfiles mounts ipv6"
PACKAGECONFIG[postgresql]  = "--with-database=postgresql --enable-xml-log,, postgresql"
PACKAGECONFIG[suidcheck]  = "--enable-suidcheck,, "
PACKAGECONFIG[logwatch]  = "--enable-login-watch,, "
PACKAGECONFIG[mounts]  = "--enable-mounts-check,, "
PACKAGECONFIG[userfiles]  = "--enable-userfiles,, "
PACKAGECONFIG[ipv6]  = "--enable-ipv6,--disable-ipv6,"

do_configure_prepend () {
    export PGSQL_HOME="${STAGING_DIR_HOST}${exec_prefix}"
    export PGSQL_LIB_DIR="${STAGING_LIBDIR}"
    export PGSQL_INC_DIR="${STAGING_INCDIR}"
}

pkg_postinst_${PN} () {
    if [ -z "$D" ]; then
        if [ -e ${sysconfdir}/init.d/populate-volatile.sh ]; then
            ${sysconfdir}/init.d/populate-volatile.sh update
        fi
    fi
}

