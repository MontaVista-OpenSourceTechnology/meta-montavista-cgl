# Copyright (c) 2010 - 2012 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

DESCRIPTION = "CPU frequency adjusting daemon"
SECTION = "base"
HOMEPAGE = "http://carlthompson.net/Software/CPUSpeed"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://../license.txt;md5=f9d401383222fa8796221565eaa567d2"
PR = "r2"
COMPATIBLE_HOST = "(i.86|x86_64|powerpc).*-linux"

#LOCATION="http://www.carlthompson.net/downloads/cpuspeed/"
LOCATION="https://github.com/MontaVista-OpenSourceTechnology/source-mirror/raw/master/"
SRC_URI = "${LOCATION}/cpuspeed-${PV}.tar.bz2;name=src \
           ${LOCATION}/license.txt;name=license \
	   file://cpuspeed-1.5-Makefile.patch;patch=1 \
	   file://cpuspeed-1.5-no-affected_cpus-fallback.patch;patch=1 \
	   file://cpuspeed.init \
	   file://cpuspeed.conf \
	   file://cpuspeed.8 \
	  "

inherit update-rc.d
	 
S = "${WORKDIR}/cpuspeed-${PV}"

INITSCRIPT_NAME = "cpuspeed"
INITSCRIPT_PARAMS = "defaults 13 99"

do_compile() {
        ${CXX} ${TARGET_CXXFLAGS} ${LDFLAGS} -o cpuspeed cpuspeed.cc
}

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/sysconfig
	install -d ${D}${mandir}/man8

	#start installing cpuspeed files
	install -m 0755 ${S}/cpuspeed ${D}${sbindir}
	install -m 0755 ${WORKDIR}/cpuspeed.init ${D}${sysconfdir}/init.d/cpuspeed
	install -m 0644 ${WORKDIR}/cpuspeed.conf ${D}${sysconfdir}/sysconfig/cpuspeed
	install -m 0644 ${WORKDIR}/cpuspeed.8 ${D}${mandir}/man8/cpuspeed.8
}

CONFFILES_${PN} += "${sysconfdir}/sysconfig/cpuspeed"

pkg_postinst_${PN}() {
}

pkg_postrm_${PN}() {
}

SRC_URI[src.md5sum] = "4ff58ec10678db80a08bd5ad3589e838"
SRC_URI[src.sha256sum] = "fd0215ccc73f00a1ab826142749720787594b484c551615909cbfc811912defe"
SRC_URI[license.md5sum] = "f9d401383222fa8796221565eaa567d2"
SRC_URI[license.sha256sum] = "4d0a2f500d951d1c75653d595ec731df18955ef149350cc3e09d477ddc16c4b4"
