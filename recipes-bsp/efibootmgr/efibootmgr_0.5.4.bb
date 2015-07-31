DESCRIPTION = "Efibootmgr is a Linux user-space application to modify \
the Intel Extensible Firmware Interface (EFI) Boot Manager configuration."
SECTION = "console/utils"
HOMEPAGE = "http://packages.debian.org/squeeze/efibootmgr"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"
PR = "r2"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/e/efibootmgr/efibootmgr_${PV}.orig.tar.gz \
           file://efibootmgr_0.5.4-2.diff \
	   "

DEPENDS = "pciutils zlib"
COMPATIBLE_HOST = "(i.86|x86_64).*-linux"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = ""

do_configure() {
:
}

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}{sbindir_native} ${D}${docdir}/${P} ${D}${mandir}/man8
	oe_runmake BINDIR="${D}${sbindir}" install
	install -m 644 COPYING ${D}${docdir}/${P}
	install -m 644 INSTALL ${D}${docdir}/${P}
	install -m 644 README ${D}${docdir}/${P}
	install -m 644 src/man/man8/* ${D}${mandir}/man8
}

SRC_URI[md5sum] = "cfcf24752d6461b73f7ba964bbf73169"
SRC_URI[sha256sum] = "b562a47a4f5327494992f2ee6ae14a75c5aeb9b4a3a78a06749d5cd2917b8e71"
