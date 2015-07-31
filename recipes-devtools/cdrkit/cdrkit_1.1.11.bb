DESCRIPTION = "A set of tools for CD recording"
HOMEPAGE = "http://www.cdrkit.org"
DEPENDS = "libcap bzip2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b30d3b2750b668133fc17b401e1b98f8"

PR = "r2"
SRC_URI = " \
	http://cdrkit.org/releases/cdrkit-${PV}.tar.gz;name=archive \
	file://xconfig.patch \
"

inherit cmake

# Some test scripts use mkisofs to create ISO image, so create
# symlink to genisoimage.
do_install_append () {
	ln -sf genisoimage ${D}${bindir}/mkisofs
}

CONFLICTS_${PN} = "cdrtools"

SRC_URI[archive.md5sum] = "efe08e2f3ca478486037b053acd512e9"
SRC_URI[archive.sha256sum] = "d1c030756ecc182defee9fe885638c1785d35a2c2a297b4604c0e0dcc78e47da"
