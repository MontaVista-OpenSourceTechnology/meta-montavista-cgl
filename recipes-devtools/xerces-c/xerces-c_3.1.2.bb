DESCRIPTION = "Xerces-c is a validating xml parser written in C++"
HOMEPAGE = "http://xerces.apache.org/xerces-c/"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r1"

SRC_URI = "http://apache.lauf-forum.at/xerces/c/3/sources/${BP}.tar.bz2"

inherit autotools

PACKAGES = "libxerces-c \
            libxerces-c-dbg \
            libxerces-c-dev \
            xerces-c-samples \
            xerces-c-samples-dbg \
            libxerces-c-staticdev \
	    " 

FILES_libxerces-c = "${libdir}/libxerces-c-3.1.so"
FILES_libxerces-c-dbg = "${libdir}/.debug \ 
                         ${prefix}/src/debug "
FILES_libxerces-c-dev = "${libdir}/lib*.la \
                         ${libdir}/libxerces-c.so \
                         ${libdir}/pkgconfig/xerces-c.pc \
                         ${includedir}/xercesc \
			 "
FILES_xerces-c-samples = "${bindir}/*"
FILES_xerces-c-samples-dbg = "${bindir}/.debug/"
FILES_libxerces-c-staticdev = "${libdir}/lib*.a"

SRC_URI[md5sum] = "d987b8bb576aea456e92454781fe3615"
SRC_URI[sha256sum] = "95d8655c4c50668ad60d555b59da9f31937b2c53638aa8d5768cb169f192d5e1"


PACKAGECONFIG ??= "curl icu"
PACKAGECONFIG[curl] = "--with-curl=yes,--with-curl=no,curl"
PACKAGECONFIG[icu] = "--with-icu=yes,--with-icu=no,icu"

BBCLASSEXTEND += "native"
