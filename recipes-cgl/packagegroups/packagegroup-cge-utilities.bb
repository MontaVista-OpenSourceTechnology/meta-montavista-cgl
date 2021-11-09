
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
RDEPENDS:packagegroup-cge-utilities = "\
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

RDEPENDS:packagegroup-cge-ftpserver-utilities = " \
"
IPMIUTIL = ""
IPMIUTIL:x86 = "ipmiutil"
IPMIUTIL:x86-64 = "ipmiutil"
RDEPENDS:packagegroup-cge-utility-hardware = "\
	libscsihotswap \
    ${IPMIUTIL} \
"

RDEPENDS:packagegroup-cge-utility-hardware += "\
					${X86_PACKAGES_HARDWARE_UTILS} \
					${POWERPC_PACKAGES_HARDWARE_UTILS} \
					"
X86_PACKAGES_HARDWARE_UTILS ?= ""
POWERPC_PACKAGES_HARDWARE_UTILS ?= ""

X86_PACKAGES_HARDWARE_UTILS:x86-64 = " \
	cpuspeed \
"

X86_PACKAGES_HARDWARE_UTILS_i686 = " \
	cpuspeed \
"

POWERPC_PACKAGES_HARDWARE_UTILS:powerpc = " \
	cpuspeed \
"

RDEPENDS:packagegroup-cge-utility-system-management = "\
"

RDEPENDS:packagegroup-cge-utility-system-management += "\
	${X86_PACKAGES_SYSTEMMGMT_UTILS} \
"

X86_PACKAGES_SYSTEMMGMT_UTILS ?= ""
X86_PACKAGES_SYSTEMMGMT_UTILS:x86-64 = " \
	dmidecode \
"
X86_PACKAGES_SYSTEMMGMT_UTILS_i686 = " \
	dmidecode \
"

PREFERRED_PROVIDER_libunwind ?= "libunwind"
RDEPENDS:packagegroup-cge-utility-debug = " \
	${PREFERRED_PROVIDER_libunwind} \
	pcoredump \
	ltt-kdump \
"

RDEPENDS:packagegroup-cge-utility-network-management = "\
"

RDEPENDS:packagegroup-cge-security = "\
"

RDEPENDS:packagegroup-cge-logs-management = " \
"
# FIXME missing get_kernel_syms
#	evlog 
#	evlog-telco 
#Missing from latest content
#eventlog 

# FIXME ace and opendiameter
#	ace 
#	opendiameter
RDEPENDS:packagegroup-cge-libs = "\
	libyaml \
	swig \
"
# FIXME: not sure why this is misssing
#	ustr
# FIXME ace not building
#	ace 
#	opendiameter

RDEPENDS:packagegroup-cge-boot-utilities = "\
	bootcycle \
"

RDEPENDS:packagegroup-cge-boot-utilities += " \
"

RDEPENDS:packagegroup-cge-virualization-utilities += "${X86_PACKAGES_VIRTUALIZATION_UTILS}"

X86_PACKAGES_VIRTUALIZATION_UTILS = ""
X86_PACKAGES_VIRTUALIZATION_UTILS:x86-64 = " \
	qemu \
"
X86_PACKAGES_VIRTUALIZATION_UTILS_i686 = " \
	qemu \
"
