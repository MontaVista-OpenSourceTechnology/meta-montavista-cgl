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

PR = "r1"
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
EXTRA_OECONF_append += "--mandir=${datadir}/${PN}/man"

CFLAGS += "${@extra_cflags(d)}"

do_configure_prepend () {
    sed -i "s:^mandir = .*:mandir = @mandir@:g" ${S}/doc/Makefile.in ${S}/doc/Makefile.am
}

FILES_${PN} += "${libdir}"
FILES_${PN}-doc += "${datadir}/${PN}/man"

SRC_URI[md5sum] = "0d448d14726e2fda0eb9451fb2866a5c"
SRC_URI[sha256sum] = "b80303b6f05cbe48e728dd925fef201e9604a90cd3fc9c8af113367e8d6dbe57"
