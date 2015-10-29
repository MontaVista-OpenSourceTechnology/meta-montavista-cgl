
# Copyright (C) 2014 Montavista Inc
#

SUMMARY = "CGE Functionality"
DESCRIPTION = "Features required to implement carrier grade functionality"
PR = "r1"
LICENSE = "MIT"

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
    "


RDEPENDS_packagegroup-cge-utility-hardware = "\
	acpitool \
	cdrkit \
	drbd-utils \
	ipmiutil \
	libscsihotswap \
	openhpi \
	openipmi \
	paxctl \
	scsirastools \
	smartmontools \
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

RDEPENDS_packagegroup-cge-utility-system-management = "\
	adduser \
	daemontools \
	hpitest \
	lksctp-tools \
	ocfs2-tools \
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

RDEPENDS_packagegroup-cge-utility-debug = "\
	gdb-kdump-helpers \
	libunwind \
	pcoredump \
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
	"
RDEPENDS_packagegroup-cge-security = "\
	cyrus-sasl \
	edac-utils \
	ipsec-tools \
	liblockfile \
	lockfile-progs \
	pinentry \
	samhain-client \
	samhain-server \
	wireshark \
        adduser \
	"

RDEPENDS_packagegroup-cge-logs-management = "\
	eventlog \
	evlog \
	evlog-telco \
	syslog-ng \
	"
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
	ustr \
	"

RDEPENDS_packagegroup-cge-boot-utilities = "\
	bootcycle \
	ipxe \
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

