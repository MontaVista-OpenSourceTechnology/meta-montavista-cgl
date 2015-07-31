DESCRIPTION = "create a TCP or a UNIX domain socket and connect to stdin/out"
HOMEPAGE = "ftp://ftp.cs.tu-berlin.de"
LICENSE = "GPLv2"

PR = "r1"

LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=cf186a8bd339e4b84d2f575514237891"
SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/socket_1.1.orig.tar.gz;name=archive \
           https://launchpad.net/ubuntu/+archive/primary/+files/socket_1.1-10.diff.gz;name=patch \
          "

SRC_URI[archive.md5sum] = "4beae4ed6ebe5bb8770686948b1e074a"
SRC_URI[archive.sha256sum] = "7df3eae9f23d13984f15b3b292ed1c79ca8624977c6ea46710c659a7c65ae77a"
SRC_URI[patch.md5sum] = "ba48f165223e36ab85aa53b26c2aa300"
SRC_URI[patch.sha256sum] = "e1630e919dc46603a30633a62f0de7ffcc7b2cb8f8bc944fbe50e6e1808a49bf"

inherit autotools

S = "${WORKDIR}/${BPN}-${PV}.orig"
B = "${S}"

EXTRA_OEMAKE += "-e" 

do_install_prepend () {
    install -d ${D}${bindir}
}
