DESCRIPTION = "Enterprise Event Logging"
HOMEPAGE = "http://evlog.sourceforge.net"
LICENSE = "GPLv2 & LGPLv2"
LIC_FILES_CHKSUM = "file://README;beginline=48;endline=63;md5=9d9dfbcaca3590ba9804a88258574b18"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/evlog/evlog-${PV}.tar.gz \
           file://mvista.diff;apply=yes \
           file://libtool.diff;apply=yes \
           file://fix_evl_log.diff;apply=yes \
           file://remote-patch;apply=yes \
           file://lseek64-patch;apply=yes \
           file://empty-log-patch;apply=yes \
           file://dup-patch;apply=yes \
           file://evlconfig-patch;apply=yes \
           file://evlactiond-patch;apply=yes \
           file://evlnewlog-patch;apply=yes \
           file://evlginzu-patch;apply=yes \
           file://lib-cleanup;apply=yes \
           file://secure-logging;apply=yes \
           file://extern.diff;apply=yes \
           file://ksym_mod-asm-atomic.diff;apply=yes \
           file://evlginzu-remove_fix.patch;apply=yes \
           file://evlginzu-eventless_fix.patch;apply=yes \
           file://evlginzu-suppress_fix.patch;apply=yes \
           file://evlog-fix-cpp.patch;apply=yes \
           file://evlog-fix-test-failures.patch;apply=yes \
           file://evlog-man-colon.patch;apply=yes \
           file://evlconfig-socket-write.patch;apply=yes \
           file://evlogmgr-prog-name.patch;apply=yes \
           file://evlnotify-man-list.patch;apply=yes \
           file://fix-syslogat.patch;apply=yes \
           file://evl-fix-ppc-tests.patch;apply=yes \
           file://evl-clear-unused-x86-log-double-bits.patch;apply=yes \
           file://evlog-ppc64.patch;apply=yes \
           file://evlog-arm-convert-fix.patch;apply=yes \
           file://evlog-mips.patch;apply=yes \
           file://evlog-add-32-64-compat.patch;apply=yes \
           file://evlogd-memory-leak-fix.patch;apply=yes \
           file://evlactiond-error-logging-fix.patch;apply=yes \
           file://evlactiond-error-logging-fix-2.patch;apply=yes \
           file://cge60fixes.patch;apply=yes \
           file://evlog_siginfo_t.patch;apply=yes \
           file://evlog_q_tab_h_fix.patch;apply=yes \
           file://evlog-make-sbin-configurable.patch \
           file://evlog-cleanup-init-scripts.patch \
           file://evlog-aarch64-support.patch \
           file://add-config-h.patch \
           file://evlog-fix-test-dest.patch \
           file://fix-hardcoded-lib-path.patch \
          "

SRC_URI[md5sum] = "b4cf6d696c827bf72b67532950c3bf9f"
SRC_URI[sha256sum] = "739984b2770a2c4356431881f4f1b618191cd6979c7b35d88460a49b500f01bb"

# libbfd and libiberty packages are given by binutils
DEPENDS = "zlib bison-native flex-native binutils"

RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-test = "bash"

inherit autotools update-rc.d

B = "${S}"
EXTRA_OECONF += "--with-plugindir=${libdir}/${PN}/plugins --sbindir=${sbindir}"
INITSCRIPT_NAME = "evlog"
INITSCRIPT_PARAMS = "defaults 9 90"

PACKAGES =+ "${PN}-tests-dbg ${PN}-tests"
FILES_${PN}-tests += "${localstatedir}/${PN}/test"
FILES_${PN}-tests-dbg += "${localstatedir}/${BPN}/test/.debug"
FILES_${PN}-staticdev += "${libdir}/${PN}/plugins/*.a"
FILES_${PN}     += "${libdir}/${PN}/plugins/*.so \
                    ${libdir}/${PN}/plugins/*.la"
FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug \
                    ${datadir}/${BPN}/.debug"
FILES_${PN}-doc += "${datadir}/${PN}"

do_configure_prepend () {
    touch NEWS AUTHORS ChangeLog
}

do_install_append() {
    # pack template files into one package
    mv ${D}${datadir}/doc/packages/evlog/templates ${D}${datadir}/${PN}
}


PARALLEL_MAKE = ""
pkg_postinst_${PN}() {
    if test "x$D" != "x"; then
        exit 1
    else
        update-rc.d -s evlaction defaults 90 40
        update-rc.d -s evlnotify defaults 80 50
        update-rc.d -s evlogrmt defaults 9 90
    fi
}

pkg_prerm_${PN}() {
    if test "x$D" != "x"; then
        exit 1
    else
        for script in evlogrmt evlnotify evlaction; do
            update-rc.d -f $script remove
        done
    fi
}
