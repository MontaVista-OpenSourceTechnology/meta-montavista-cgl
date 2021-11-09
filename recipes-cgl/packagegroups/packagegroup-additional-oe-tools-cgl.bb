
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
RDEPENDS:packagegroup-additional-oe-tools-cgl = "\
	packagegroup-oe-virtualization-cgl \
	packagegroup-oe-webserver-cgl \
	packagegroup-oe-console-utilities-cgl \
	packagegroup-oe-filesystem-utilities-cgl \
	"

RDEPENDS:packagegroup-oe-virtualization-cgl = "\
"

RDEPENDS:packagegroup-oe-console-utilities-cgl = "\
"

RDEPENDS:packagegroup-oe-webserver-cgl =" \
"

RDEPENDS:packagegroup-oe-filesystem-utilities-cgl = " \
	e2fsprogs-resize2fs \
"	
