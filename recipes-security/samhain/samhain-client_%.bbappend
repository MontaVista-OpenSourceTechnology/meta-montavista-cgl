PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://fix-install-paths.patch \
            file://samhain_test_9.patch \
            file://donot-include-host-sys-flags.patch"

EXTRA_OECONF += "--enable-network=${SAMHAIN_MODE} --with-logserver=127.0.0.1"

PACKAGECONFIG ??= "postgresql suidcheck logwatch userfiles mounts ipv6"
PACKAGECONFIG[postgresql]  = "--with-database=postgresql --enable-xml-log,,postgresql"
PACKAGECONFIG[suidcheck]  = "--enable-suidcheck,,,"
PACKAGECONFIG[logwatch]  = "--enable-login-watch,,,"
PACKAGECONFIG[mounts]  = "--enable-mounts-check,,,"
PACKAGECONFIG[userfiles]  = "--enable-userfiles,,,"
PACKAGECONFIG[ipv6]  = "--enable-ipv6,--disable-ipv6,,"

do_configure_prepend () {
    export PGSQL_HOME="${STAGING_DIR_HOST}${exec_prefix}"
}
