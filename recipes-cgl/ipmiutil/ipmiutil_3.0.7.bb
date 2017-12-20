DESCRIPTION = "ipmiutil is an easy-to-use set of IPMI server management utilities.\
	       It can get/set sensor thresholds, automate SEL management, do SOL console, etc."
HOMEPAGE = "http://ipmiutil.sourceforge.net"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=626a5970304daa1fcb87f757fb42b795"
DEPENDS="openssl-native openssl"
PARALLEL_MAKE = ""
SRC_URI = "${SOURCEFORGE_MIRROR}/ipmiutil/ipmiutil-${PV}.tar.gz \
	  " 
# file://use-cross-ar.patch 

PR = "r0"
#FIXME:
ERROR_QA_remove = "dev-elf"
def extra_cflags(d):
    import bb
    import re
    archm = d.getVar('TARGET_ARCH', True)
    if re.match('^ia64',archm): return "-D__IA64__"
    elif re.match('^ppc64',archm): return "-DSTUB_IO"
    elif re.match('^x86_64',archm): return ""
    elif re.match('^i386',archm): return ""
    elif re.match('^i586',archm): return ""
    elif re.match('^i686',archm): return ""
    elif re.match('^sun4u',archm): return "-D__SPARC__"
    return "-DSTUB_IO"

inherit autotools

B = "${S}"

CFLAGS += "${@extra_cflags(d)}"

FILES_${PN} += "${libdir}"

SRC_URI[md5sum] = "f055613809d14f9aa07fa23f90ed202a"
SRC_URI[sha256sum] = "defc2fad88c184d953b5e37c42a95b0b14ed9772c097b00471e157be3e23542f"
