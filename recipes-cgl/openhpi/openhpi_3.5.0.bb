DESCRIPTION = "OpenHPI, open source implementation of the Service Availability Forum (SAF) Hardware Platform Interface"
HOMEPAGE = "http://www.openhpi.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e3c772a32386888ccb5ae1c0ba95f1a4"

PR = "r4"
SRC_URI = "${SOURCEFORGE_MIRROR}/openhpi/openhpi-${PV}.tar.gz \
           file://sysfs.patch;apply=yes \
           file://xmlheaders.patch;apply=yes \
           file://openhpid.patch;apply=yes \
           file://openhpid_status_check.patch;apply=yes"

DEPENDS = "glib-2.0 libtool sysfsutils libxml2 net-snmp e2fsprogs libgcrypt libgpg-error libcap"
INITSCRIPT_NAME = "openhpid"
INITSCRIPT_PARAMS = "start 50 2 3 4 5 . stop 50 0 1 6 ."
EXTRA_OECONF += "--with-net-snmp-config=${STAGING_BINDIR}/net-snmp-config"

inherit autotools autotools_stage update-rc.d

LEAD_SONAME = "libopenhpi.so.2"
# Pull lsb, lsbinitscripts to start openhpid services"
RDEPENDS_${PN} += "lsb lsbinitscripts"

do_install_append() {
	sed -i "s|/etc/init.d/init-functions|${base_libdir}/lsb/init-functions|" \
	${D}${INIT_D_DIR}/openhpid
}

PACKAGES = "${PN}-dbg ${PN}-libs ${PN}-dev ${PN}-doc ${PN}-staticdev ${PN}"

FILES_${PN}-libs = "${libdir}/*.so.*"
FILES_${PN}-dev += "${libdir}/*.la \
                    ${libdir}/openhpi/*.so"

SRC_URI[md5sum] = "6fb7a9fd60463d2a1a9d21af2c21a941"
SRC_URI[sha256sum] = "3eccd33c24af71aefb28816cfb3b3002176829267c142657d109f297c59ce64f"
