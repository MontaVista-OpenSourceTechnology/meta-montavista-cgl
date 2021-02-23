
# Copyright (C) 2014 Montavista Inc
#

SUMMARY = "CGE Functionality"
DESCRIPTION = "Features required to implement carrier grade functionality"
PR = "r2"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "\
    packagegroup-cge-utilities \
    packagegroup-cge-utility-hardware \
    packagegroup-cge-utility-network-management \
    packagegroup-cge-security \
    packagegroup-cge-logs-management \
    packagegroup-cge-libs \
    packagegroup-cge-boot-utilities \
    packagegroup-cge-virualization-utilities \
    packagegroup-cge-utility-system-management \
    packagegroup-cge-utility-debug \
    packagegroup-cge-console-utilities \
    packagegroup-cge-ftpserver-utilities \
    "
RDEPENDS_packagegroup-cge-utilities = "\
    packagegroup-cge-utility-hardware \
    packagegroup-cge-utility-network-management \
    packagegroup-cge-security \
    packagegroup-cge-logs-management \
    packagegroup-cge-libs \
    packagegroup-cge-boot-utilities \
    packagegroup-cge-virualization-utilities \
    packagegroup-cge-utility-system-management \
    packagegroup-cge-utility-debug \
    packagegroup-cge-ftpserver-utilities \
    "

RDEPENDS_packagegroup-cge-ftpserver-utilities = " \
"
IPMIUTIL = ""
IPMIUTIL_x86 = "ipmiutil"
IPMIUTIL_x86-64 = "ipmiutil"
RDEPENDS_packagegroup-cge-utility-hardware = "\
	libscsihotswap \
    ${IPMIUTIL} \
"

RDEPENDS_packagegroup-cge-utility-hardware += "\
					${X86_PACKAGES_HARDWARE_UTILS} \
					${POWERPC_PACKAGES_HARDWARE_UTILS} \
					"
X86_PACKAGES_HARDWARE_UTILS ?= ""
POWERPC_PACKAGES_HARDWARE_UTILS ?= ""

X86_PACKAGES_HARDWARE_UTILS_x86-64 = " \
	cpuspeed \
"

X86_PACKAGES_HARDWARE_UTILS_i686 = " \
	cpuspeed \
"

POWERPC_PACKAGES_HARDWARE_UTILS_powerpc = " \
	cpuspeed \
"

RDEPENDS_packagegroup-cge-utility-system-management = "\
"

RDEPENDS_packagegroup-cge-utility-system-management += "\
	${X86_PACKAGES_SYSTEMMGMT_UTILS} \
"

X86_PACKAGES_SYSTEMMGMT_UTILS ?= ""
X86_PACKAGES_SYSTEMMGMT_UTILS_x86-64 = " \
	dmidecode \
"
X86_PACKAGES_SYSTEMMGMT_UTILS_i686 = " \
	dmidecode \
"

PREFERRED_PROVIDER_libunwind ?= "libunwind"
RDEPENDS_packagegroup-cge-utility-debug = " \
	${PREFERRED_PROVIDER_libunwind} \
	pcoredump \
	ltt-kdump \
"

RDEPENDS_packagegroup-cge-utility-network-management = "\
"

RDEPENDS_packagegroup-cge-security = "\
"

RDEPENDS_packagegroup-cge-logs-management = " \
"
# FIXME missing get_kernel_syms
#	evlog 
#	evlog-telco 
#Missing from latest content
#eventlog 

# FIXME ace and opendiameter
#	ace 
#	opendiameter
RDEPENDS_packagegroup-cge-libs = "\
	libyaml \
	swig \
"
# FIXME: not sure why this is misssing
#	ustr
# FIXME ace not building
#	ace 
#	opendiameter

RDEPENDS_packagegroup-cge-boot-utilities = "\
	bootcycle \
"

RDEPENDS_packagegroup-cge-boot-utilities += " \
"

RDEPENDS_packagegroup-cge-virualization-utilities += "${X86_PACKAGES_VIRTUALIZATION_UTILS}"

X86_PACKAGES_VIRTUALIZATION_UTILS = ""
X86_PACKAGES_VIRTUALIZATION_UTILS_x86-64 = " \
	qemu \
"
X86_PACKAGES_VIRTUALIZATION_UTILS_i686 = " \
	qemu \
"
