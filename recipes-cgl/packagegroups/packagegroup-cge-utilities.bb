
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

RDEPENDS_packagegroup-cge-ftpserver-utilities = "\
	lftp \
	"

RDEPENDS_packagegroup-cge-utility-hardware = "\
	acpitool \
	cdrkit \
	drbd-utils \
	drbd \
	ipmiutil \
	libscsihotswap \
	openhpi \
	openipmi \
	paxctl \
	scsirastools \
	smartmontools \
	nbd-client \
	nbd-server \
	nbd-trdump \
	"
RDEPENDS_packagegroup-cge-utility-hardware += "\
					${X86_PACKAGES_HARDWARE_UTILS} \
					${POWERPC_PACKAGES_HARDWARE_UTILS} \
					"
X86_PACKAGES_HARDWARE_UTILS = ""
POWERPC_PACKAGES_HARDWARE_UTILS = ""

X86_PACKAGES_HARDWARE_UTILS_x86-64 = " \
		pmtools \
		cpuspeed \
		numactl \
		"

X86_PACKAGES_HARDWARE_UTILS_i686 = " \
		pmtools \
		cpuspeed \
		numactl \
		"

POWERPC_PACKAGES_HARDWARE_UTILS_powerpc = " \
		cpuspeed \
		numactl \
		"

EDACUTILS = ""
EDACUTILS_x86-64 = "edac-utils" 
EDACUTILS_i686 = "edac-utils" 

IPXE = ""
IPXE_x86-64 = "ipxe"
IPXE_i686 = "ipxe"

RDEPENDS_packagegroup-cge-utility-system-management = "\
	adduser \
	daemontools \
	hpitest \
	lksctp-tools \
	tipcutils \
	"



RDEPENDS_packagegroup-cge-utility-system-management += "\
					${X86_PACKAGES_SYSTEMMGMT_UTILS} \
					"
X86_PACKAGES_SYSTEMMGMT_UTILS = ""
X86_PACKAGES_SYSTEMMGMT_UTILS_x86-64 = " \
		dmidecode \
		"
X86_PACKAGES_SYSTEMMGMT_UTILS_i686 = " \
		dmidecode \
		"
LTRACE="ltrace"
LTRACE_aarch64 = ""
PREFERRED_PROVIDER_libunwind ?= "libunwind"
RDEPENDS_packagegroup-cge-utility-debug = "\
	gdb-kdump-helpers \
	${PREFERRED_PROVIDER_libunwind} \
	pcoredump \
	ltt-kdump \
	"
#provided by busybox
#	start-stop-daemon


RDEPENDS_packagegroup-cge-utility-network-management = "\
	ifenslave \
	libcap-ng \
	netkit-telnet \
	openl2tp \
	openldap \
	quagga \
	strongswan \
	tunctl \
	stunnel \
	ptpd \
	"
RDEPENDS_packagegroup-cge-security = "\
	cyrus-sasl \
	${EDACUTILS} \
	ipsec-tools \
	liblockfile \
	lockfile-progs \
	pinentry \
	wireshark \
        adduser \
	"

RDEPENDS_packagegroup-cge-logs-management = "\
	eventlog \
	syslog-ng \
	logcheck \
	"
# FIXME missing get_kernel_syms
#	evlog 
#	evlog-telco 

RDEPENDS_packagegroup-cge-libs = "\
	ace \
	lemon \
	libc-client \
	libol \
	libyaml \
	mysql5 \
	opendiameter \
	opensaf \
	postgresql \
	swig \
	"
# FIXME: not sure why this is misssing
#	ustr

RDEPENDS_packagegroup-cge-boot-utilities = "\
	bootcycle \
	${IPXE} \
	"

RDEPENDS_packagegroup-cge-boot-utilities += "${X86_PACKAGES_BOOT_UTILS}"

X86_PACKAGES_BOOT_UTILS = ""

X86_PACKAGES_BOOT_UTILS_x86-64 = " \
		efibootmgr \
		gnu-efi \
		"

X86_PACKAGES_BOOT_UTILS_i686 = " \
		efibootmgr \
		gnu-efi \
		"

RDEPENDS_packagegroup-cge-virualization-utilities += "${X86_PACKAGES_VIRTUALIZATION_UTILS}"

X86_PACKAGES_VIRTUALIZATION_UTILS = ""
X86_PACKAGES_VIRTUALIZATION_UTILS_x86-64 = " \
		qemu \
		"
X86_PACKAGES_VIRTUALIZATION_UTILS_i686 = " \
		qemu \
		"

