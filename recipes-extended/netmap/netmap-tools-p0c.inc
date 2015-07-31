SECTION = "devel"
SUMMARY = "netmap tools"
DESCRIPTION = "The fast packet I/O framework"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README;md5=998eaad7db2c27b04f63f07bab2bcb35"

DEPENDS = "libpcap"

S = "${WORKDIR}/netmap-release"
B = "${S}/examples"

do_compile() {
	cd ${S}/examples;
	oe_runmake CFLAGS+="-I../sys" LDFLAGS+="-lpthread -lpcap -lrt" pkt-gen
}

do_install() {
	install -d ${D}/${bindir}
	install -m 755 ${S}/examples/pkt-gen ${D}/${bindir}
}

FILES_${PN} += "${bindir}/*"
