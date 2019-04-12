RDEPENDS_packagegroup-cge-utility-hardware_append = " \
	acpitool \
	scsirastools \
"

X86_PACKAGES_HARDWARE_UTILS_append_x86-64 = " \
	pmtools \
	numactl \
"

X86_PACKAGES_HARDWARE_UTILS_append_i686 = " \
	pmtools \
	numactl \
"

POWERPC_PACKAGES_HARDWARE_UTILS_append_powerpc = " \
	numactl \
"

EDACUTILS = ""
EDACUTILS_x86-64 = "edac-utils"
EDACUTILS_i686 = "edac-utils"

RDEPENDS_packagegroup-cge-utility-system-management_append = " \
	daemontools \
	hpitest \
	tipcutils \
"

LTRACE = "ltrace"
LTRACE_aarch64 = ""

RDEPENDS_packagegroup-cge-security_append = " \
	${EDACUTILS} \
"

RDEPENDS_packagegroup-cge-libs_append = " \
	lemon \
	mariadb \
"


