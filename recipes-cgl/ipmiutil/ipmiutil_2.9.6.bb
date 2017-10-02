DESCRIPTION = "ipmiutil is an easy-to-use set of IPMI server management utilities.\
	       It can get/set sensor thresholds, automate SEL management, do SOL console, etc."
HOMEPAGE = "http://ipmiutil.sourceforge.net"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f9372493401f309e6149dd2ce0a044b"
DEPENDS="openssl-native openssl"
PARALLEL_MAKE = ""
SRC_URI = "${SOURCEFORGE_MIRROR}/ipmiutil/ipmiutil-${PV}.tar.gz \
           file://use-cross-ar.patch \
	  " 

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
do_configure_append() {
    sed -i "s/sysdto\ =\ \${DESTDIR}/sysdto\ =\ /" scripts/Makefile.am
    sed -i "s/sysdto\ =\ \${DESTDIR}/sysdto\ =\ /" scripts/Makefile.in
}

FILES_${PN} += "${libdir}"

SRC_URI[md5sum] = "462087995f05fa9e692ed7f55c840f71"
SRC_URI[sha256sum] = "884c1f3d8bfb0b33c303973d286c3166f5a537976451a0312e3524af54771519"
