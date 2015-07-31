DESCRIPTION = "mime-construct constructs and (by default) mails MIME messages"
LICENSE = "GPLv2"
HOMEPAGE = "http://search.cpan.org/~rosch/mime-construct/mime-construct"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=5e2e5da619ac8ef8c84767ccc4656e96"
RDEPENDS_${PN} = "postfix"

PR = "r1"

SRC_URI = "http://www.cpan.org/authors/id/R/RO/ROSCH/mime-construct-${PV}.tar.gz \
           file://WaitStat.pm \
           file://Signal.pm \
"
SRC_URI[md5sum] = "73834ea780fbea81b89dbd9b2fb54f58"
SRC_URI[sha256sum] = "4cd7bb61b51d41192d1498c1051aa6a4ccd75aeb09b71d2ec706a7084a4a9303"

inherit cpan

do_compile () {
    perl Makefile.PL

}
do_install () {
    make install DESTDIR="${D}"
    install -d ${D}${libdir}/perl/vendor_perl/${@get_perl_version(d)}/Proc \
               ${D}${libdir}/perl/vendor_perl/${@get_perl_version(d)}/IPC
    install -m 644 ${WORKDIR}/WaitStat.pm ${D}${libdir}/perl/vendor_perl/${@get_perl_version(d)}/Proc
    install -m 644 ${WORKDIR}/Signal.pm ${D}${libdir}/perl/vendor_perl/${@get_perl_version(d)}/IPC
}
