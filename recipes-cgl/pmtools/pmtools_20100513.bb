DESCRIPTION = "This is a small collection of power management test and investigation tools"
HOMEPAGE = "http://lesswatts.org/projects/acpi"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

# we are unable to get pmtools of version 20100513, but through
# source rpm we can get source of this version. Hence get the older version of
# pmtools (i.e 20071116) and apply changes of 20100513 on top of
# 20071116.
SRC_URI="http://www.lesswatts.org/patches/linux_acpi/pmtools-20071116.tar.gz \
         file://pmtools_update_to_20100513.patch \        
         file://cflags.patch \
	 "
PR = "r2"
COMPATIBLE_HOST = "(i.86|x86_64).*-linux"

S="${WORKDIR}/pmtools-20071116"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/usr/bin ${D}${docdir}
	install -m 755 ${S}/acpidump/acpidump ${D}/usr/bin
	install -m 755 ${S}/acpixtract/acpixtract ${D}/usr/bin
	install -m 644 ${S}/README ${D}${docdir}
}

SRC_URI[md5sum] = "10aa00d2ae9f1b4653e3995589a394a3"
SRC_URI[sha256sum] = "91751774976e39f6237efd0326eb35196a9346220b92ad35894a33283e872748"

