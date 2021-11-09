RDEPENDS:packagegroup-cge-utility-hardware:append = " \
	acpitool \
	scsirastools \
"

X86_PACKAGES_HARDWARE_UTILS:append:x86-64 = " \
	pmtools \
	numactl \
"

X86_PACKAGES_HARDWARE_UTILS:append_i686 = " \
	pmtools \
	numactl \
"

POWERPC_PACKAGES_HARDWARE_UTILS:append:powerpc = " \
	numactl \
"

EDACUTILS = ""
EDACUTILS:x86-64 = "edac-utils"
EDACUTILS_i686 = "edac-utils"

RDEPENDS:packagegroup-cge-utility-system-management:append = " \
	daemontools \
	hpitest \
	tipcutils \
"

LTRACE = "ltrace"
LTRACE:aarch64 = ""

RDEPENDS:packagegroup-cge-security:append = " \
	${EDACUTILS} \
"

RDEPENDS:packagegroup-cge-libs:append = " \
	lemon \
	mariadb \
"


