
#
# Copyright (C) 2014 Montavista Inc
#

SUMMARY = "Additional packages"
DESCRIPTION = "Additional packages for cge complete image"
PR = "r1"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
	packagegroup-additional-oe-tools-cgl \
	packagegroup-oe-virtualization-cgl \
	packagegroup-oe-webserver-cgl \
	packagegroup-oe-console-utilities-cgl \
	packagegroup-oe-filesystem-utilities-cgl \
	"
RDEPENDS_packagegroup-additional-oe-tools-cgl = "\
	packagegroup-oe-virtualization-cgl \
	packagegroup-oe-webserver-cgl \
	packagegroup-oe-console-utilities-cgl \
	packagegroup-oe-filesystem-utilities-cgl \
	"
LIBVIRT=" \
	libvirt \  
	libvirt-dev \
"
# FIXME: libvirt neeeds qemu which does not build on mips64
LIBVIRT_qemumips64 = ""
LIBVIRT_qemumips64nfp = ""

RDEPENDS_packagegroup-oe-virtualization-cgl = "\
        ${LIBVIRT} \
	"

RDEPENDS_packagegroup-oe-console-utilities-cgl = "\
	lxc \
	cryptsetup \
	"

RDEPENDS_packagegroup-oe-webserver-cgl ="\
	apache2 \
	mod-wsgi \
	"

RDEPENDS_packagegroup-oe-filesystem-utilities-cgl = " \
	e2fsprogs-resize2fs \
	tgt \
"	
