
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
	"
RDEPENDS_packagegroup-additional-oe-tools-cgl = "\
	packagegroup-oe-virtualization-cgl \
	packagegroup-oe-webserver-cgl \
	packagegroup-oe-console-utilities-cgl \
	"


RDEPENDS_packagegroup-oe-virtualization-cgl = "\
	libvirt \  
	libvirt-dev \
	"

RDEPENDS_packagegroup-oe-console-utilities-cgl = "\
	lxc \
	"

RDEPENDS_packagegroup-oe-webserver-cgl ="\
	apache2 \
	"

