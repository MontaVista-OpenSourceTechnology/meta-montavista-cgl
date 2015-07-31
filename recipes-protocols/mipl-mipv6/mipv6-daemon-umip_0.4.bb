# Copyright (c) 2009, 2012 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)


DESCRIPTION = "UMIP is an open-source Mobile IPv6 stack for the GNU/Linux Operating System"
URL = "www.umip.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33"

SRCREV = "74528e1ffd2ecdd31e1a17f9d9ade530a86632fd"
SRC_URI = "git://git.umip.org/umip.git;protocol=git \
	   file://umip-0.4-build-fixups.patch;patch=1 \
	   file://umip_byte_order.patch;patch=1 \
	   file://mipv6.init \
	   file://example-configs-mip6.tar.gz \
	   file://create_pid_file_for_mip6d.patch \
"

DEPENDS = "virtual/kernel lsb"

PR = "r5"
S = "${WORKDIR}/git"

inherit autotools module-base update-rc.d

B = "${S}"

PARALLEL_MAKE = ""
CFLAGS =+ "-I${S}/include -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include"
INITSCRIPT_NAME = "mipv6"
INITSCRIPT_PARAMS = "defaults 75 25"

do_compile() {
        oe_runmake CFLAGS="${CFLAGS}"
}

do_install() {
        install -d ${D}${sbindir}
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/mipv6
        oe_runmake sbindir="${D}${sbindir}" initdir="${D}${sysconfdir}/init.d" mandir="${D}${mandir}" docdir="${D}${docdir}/mobile-ip6" NETWORK_MIP6_CONF="${D}${sysconfdir}" install
	install ${WORKDIR}/example-*.conf ${D}${sysconfdir}/mipv6/
	install ${WORKDIR}/mipv6.init ${D}${sysconfdir}/init.d/
	install extras/example-mn.conf ${D}${sysconfdir}/mipv6/mip6d.conf
	mv ${D}${sysconfdir}/init.d/mipv6.init ${D}${sysconfdir}/init.d/mipv6
	sed -i "s|/etc/init.d/init-functions|${base_libdir}/lsb/init-functions|" ${D}${sysconfdir}/init.d/mipv6

	# The debug level is 10 by default in the example configuration files,
	# set to to zero to avoid issues.
	sed -i 's/DebugLevel 10/DebugLevel 0/' ${D}${sysconfdir}/mipv6/mip6d.conf

	# Using pidof to check process id instead of pidofproc.
	# Sometimes it takes a moment to create /var/run/<daemon_name>.pid file,
	# when daemon is started. pidofproc checks existence of this file to
	# determine daemon started successfully or not, it prints daemon start as
	# failure, even though it is not. Sleep of 1 second can
	# also be used.
	sed -i "s|pidofproc|pidof|g" ${D}${sysconfdir}/init.d/mipv6

}

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"
RRECOMMENDS_${PN} = "kernel-module-mip6 kernel-module-ipv6"
