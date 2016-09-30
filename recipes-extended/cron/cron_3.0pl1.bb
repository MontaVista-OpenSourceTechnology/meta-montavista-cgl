# Copyright (c) 2011,2012 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

SECTION = "base"
DESCRIPTION = "Vixie cron."
LICENSE = "cron"
LIC_FILES_CHKSUM = "file://README;md5=4c97da33dcaed14965b7b2a6171ad812"
PR ="r12"

SRC_URI = "http://ibiblio.org/pub/Linux/system/daemons/cron/cron${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1 \
	   file://time.patch;patch=1 \
	   file://init \
	   file://cron-debian-3.0pl1-116.patch"

S = "${WORKDIR}/cron${PV}"

INITSCRIPT_NAME = "cron"
inherit update-rc.d

CFLAGS_append = " -I${S} -DSYS_TIME_H=0"

DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "pam", "libpam", "", d)}"
DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "audit", "audit", "", d)}"
DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "selinux", "libselinux", "", d)}"

HAVE_PAM = "${@bb.utils.contains("DISTRO_FEATURES", "pam", "1", "0", d)}"
HAVE_AUDIT = "${@bb.utils.contains("DISTRO_FEATURES", "audit", "1", "0", d)}"
HAVE_SELINUX = "${@bb.utils.contains("DISTRO_FEATURES", "selinux", "1", "0", d)}"

# The debian patch adds these and they need to be set.  Just set them to
# what they were before.
CFLAGS += '-DCRONDIR_MODE="0700"'
CFLAGS += '-DSPOOL_DIR_MODE="0700"'
CFLAGS += "-DSPOOL_DIR_GROUP='"root"'"
CFLAGS += "-DDEBIAN"

do_compile_prepend() {
	if [ "${HAVE_PAM}" == "1" ]; then
		export PAM_DEFS=-DUSE_PAM
		export PAM_LIBS=-lpam
	fi
	if [ "${HAVE_AUDIT}" == "1" ]; then
		export AUDIT_LIBS=-laudit
	fi
	if [ "${HAVE_SELINUX}" == "1" ]; then
		export SELINUX_DEFS=-DWITH_SELINUX
		export SELINUX_LIBS=-lselinux
	fi
}

INITSCRIPT_PARAMS = "start 65 2 3 4 5 . stop 45 0 1 6 ."

do_install () {
	install -d ${D}${sbindir} ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}/var/cron/tabs
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/cron
	oe_runmake 'DESTDIR=${D}' install
	chmod ugo+rx ${D}${sbindir}/* ${D}${bindir}/*
	touch ${D}${sysconfdir}/crontab
	install -d ${D}${mandir}/man1
	install -d ${D}${mandir}/man5
	install -d ${D}${mandir}/man8
	install -m 0644 crontab.1 ${D}${mandir}/man1
	install -m 0644 crontab.5 ${D}${mandir}/man5
	install -m 0644 cron.8 ${D}${mandir}/man8

	# crontabs should be in /var/spool/cron/crontabs
	rm -rf ${D}${localstatedir}/cron
	install -d ${D}${localstatedir}/spool/cron/crontabs

	# below are necessary for a complete cron environment
	mkdir -p ${D}${sysconfdir}/cron.d
	mkdir -p ${D}${sysconfdir}/cron.hourly
	mkdir -p ${D}${sysconfdir}/cron.daily
	mkdir -p ${D}${sysconfdir}/cron.weekly
	mkdir -p ${D}${sysconfdir}/cron.monthly

}

FILES_${PN} += "${localstatedir}/spool/cron ${sysconfdir}/crontab"

# Below steps are needed inorder to schedule jobs using cron 
# by normal user
pkg_postinst_${PN} () {
    if [ x"$D" != "x" ]; then
        exit 1
    fi
    addgroup crontab
    chown root:crontab ${bindir}/crontab
    chmod g+s ${bindir}/crontab

    chown root:crontab /var/spool/cron/crontabs
    chmod 0730 /var/spool/cron/crontabs/
}

pkg_postrm() {
}

SRC_URI[md5sum] = "d9f12c3edfca4a4918b8d299cce5f2b4"
SRC_URI[sha256sum] = "99602e966e12347f2728b2153537a14195b06fe130d047e8d91b4f72b24866a0"

inherit update-alternatives
ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE_${PN} = "crontab"
ALTERNATIVE_LINK_NAME[crontab] = "${bindir}/crontab"
