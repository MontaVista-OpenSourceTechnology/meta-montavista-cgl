# Copyright (c) 2010 - 2012 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-${PV}:"
SRC_URI += "file://patch-confdirfix;apply=yes \
            file://patch-mvlstartup;apply=yes \
	    file://makefile_sort_local_fix.patch;apply=yes \
	    file://fix_rpm_post_install.patch;apply=yes "

#DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "selinux", "libselinux", "", d)}"
#EXTRA_OECONF += "${@bb.utils.contains("DISTRO_FEATURES", "selinux", "--with-selinux", "", d)}"
#
#inherit update-rc.d
#
#do_install_append () {
#	install -D -m 755 smartd.initd.in ${D}${sysconfdir}/init.d/smartd
#}
#INITSCRIPT_NAME = "smartd"
#INITSCRIPT_PARAMS = "defaults"
