# Copyright (c) 2013 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

SECTION = "base"
DESCRIPTION = "PAX control utility"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=0300f1edf2b2cadb5791f85cd84b8b23"
PR ="r6"

SRC_URI = "http://pax.grsecurity.net/paxctl-${PV}.tar.gz"

do_install() {
	oe_runmake 'DESTDIR=${D}' install
}

FILES_${PN} = "/sbin/paxctl"
FILES_${PN}-doc = "/usr/share/man/man1/paxctl.1"

SRC_URI[md5sum] = "9bea59b1987dc4e16c2d22d745374e64"
SRC_URI[sha256sum] = "a330ddd812688169802a3ba29e5e3b19956376b8f6f73b8d7e9586eb04423c2e"
