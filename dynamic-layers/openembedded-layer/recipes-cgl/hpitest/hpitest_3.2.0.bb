DESCRIPTION = "Compliance test suite developed by the \
SAFORUM for its SAF Hardware Platform Interface (HPI) specifications"
HOMEPAGE = "http://sourceforge.net/projects/hpib-test"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=663350cf8df2e1c1ee9139e69040eeab"
PR = "r2"

SRC_URI = "http://download.sourceforge.net/project/hpib-test/3.x.x/hpitest-${PV}-rc1.tar.gz \
           file://headers.patch;apply=yes \
           file://readonlyfield.patch;apply=yes \
	   file://hpitest_sleep_fix.patch;apply=yes \
           file://compile-error.patch \
"


DEPENDS += "openhpi"

inherit autotools autotools

B = "${S}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 hpitest ${D}${bindir}
}

SRC_URI[md5sum] = "cf189c7a20e83407886f3bafdb71abba"
SRC_URI[sha256sum] = "ec429d943318688ca8d49a748ab10950f7758c1b46d303dfca2e66b0f67d40ab"
