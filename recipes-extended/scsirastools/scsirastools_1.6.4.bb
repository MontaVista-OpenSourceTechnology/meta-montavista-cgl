# Copyright (c) 2010,2011,2012 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

DESCRIPTION = "scsirastools adds several Linux SCSI tools that \
can be used to service and maintain disk storage devices."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=687ea108478d26152ae46eb29d9d1545"
PR = "r4"

SRC_URI = "http://prdownloads.sourceforge.net/scsirastools/scsirastools-${PV}.tar.gz \
	file://scsirastools-getline.patch;apply=yes \
	file://scsirastools-remove-binaries.patch;apply=yes \
	"

inherit autotools autotools_stage update-rc.d

PACKAGES =+ "${PN}-diskmon ${PN}-diskmon-dbg"
PACKAGES =+ "${PN}-raidmon ${PN}-raidmon-dbg"

RDEPENDS_${PN} += "bash"
RDEPENDS_${PN}-diskmon += "${PN}"
RDEPENDS_${PN}-raidmon += "${PN}"

FILES_${PN}-dbg += "/usr/share/scsirastools/.debug"

FILES_${PN}-diskmon = "${sbindir}/sgdiskmon ${sysconfdir}/init.d/sgdisk"
FILES_${PN}-diskmon-dbg = "${sbindir}/.debug/sgdiskmon"

FILES_${PN}-raidmon = "${sbindir}/sgraidmon ${sysconfdir}/init.d/sgraid"
FILES_${PN}-raidmon-dbg = "${sbindir}/.debug/sgraidmon"

INITSCRIPT_PACKAGES = "${PN}-diskmon ${PN}-raidmon"
INITSCRIPT_NAME_${PN}-diskmon = "sgdisk"
INITSCRIPT_PARAMS_${PN}-diskmon = "defaults 80 20"
INITSCRIPT_NAME_${PN}-raidmon = "sgraid"
INITSCRIPT_PARAMS_${PN}-raidmon = "defaults 80 20"

SRC_URI[md5sum] = "2d775111b62e2dfc1960a722f5fda211"
SRC_URI[sha256sum] = "38d2c6c9b04a2c594e528927b950754f94c0522718d17c78e6589ba778339bf8"
