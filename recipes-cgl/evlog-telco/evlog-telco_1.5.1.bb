DESCRIPTION = "Enterprise Event Logging Telco Extensions"
HOMEPAGE = "http://evlog-telco.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d4e2e1e108554e0388ea4aecd8d27"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/evlog-telco/evlog-telco-${PV}.tar.gz \
           file://evlsyslog.init \
           file://evlforward.init \
           file://fix_evl_log.diff;apply=yes \
           file://signal-patch;apply=yes \
           file://evlsyslog-patch;apply=yes \
           file://file_follow_forwarding.patch;apply=yes \
           file://evlog_telco_fix_examples.patch;apply=yes \
           file://pxlogger.patch;apply=yes \
           file://autotools.patch;apply=yes \
           file://evllogheader.patch;apply=yes"

SRC_URI[md5sum] = "9c7e2f2ac98fbd11ddcd73fe0713d235"
SRC_URI[sha256sum] = "e21887215767fd529ccdd75b165200951cf9f8674ab7d51d6da3c4151fa4cb18"

DEPENDS = "flex evlog flex-native"
LDFLAGS += "-Wl,--as-needed"

inherit autotools autotools update-rc.d

B = "${S}"

do_configure_prepend () {
    touch NEWS AUTHORS ChangeLog
}

do_install_append() {
    mkdir -p ${D}/sbin
    mv ${D}${sbindir}/evl* ${D}/sbin
    install -m 0755 ${WORKDIR}/evlsyslog.init ${D}${sysconfdir}/init.d/evlsyslog
    install -m 0755 ${WORKDIR}/evlforward.init ${D}${sysconfdir}/init.d/evlforward
}

pkg_postinst_${PN}() {
    if test "x$D" != "x"; then
        exit 1
    else
        update-rc.d evlsyslog defaults 85 45
    fi
}

pkg_prerm_${PN}() {
    if test "x$D" != "x"; then
        exit 1
    else
        update-rc.d -f evlsyslog remove
    fi
}

INITSCRIPT_NAME = "evlforward"
INITSCRIPT_PARAMS = "defaults 85 45"
PACKAGES = "${PN}-examples ${PN}-doc ${PN} ${PN}-dbg"

FILES_${PN}-examples = "${datadir}/${BPN}/examples \
                        ${sbindir}/pxlogger \
                        ${sbindir}/pxtestapp \
                        ${sbindir}/pxruntests"

FILES_${PN}-doc = "${mandir}/man1/*"

FILES_${PN} = "/sbin/evlsyslog \
               /sbin/evlforward \
               ${sysconfdir}/init.d/evlsyslog \
               ${sysconfdir}/init.d/evlforward"

FILES_${PN}-dbg += "/sbin/.debug/* \
                    ${sbindir}/.debug/* \
		    ${debugsrcdir}/* \
		    "
RDEPENDS_${PN} = "lsb lsbinitscripts"
