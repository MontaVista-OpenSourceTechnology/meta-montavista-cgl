require nss.inc

PR .= ".1"

SRC_URI += "\
    http://ftp.mozilla.org/pub/mozilla.org/security/nss/releases/NSS_3_19_RTM/src/${BPN}-${PV}.tar.gz \
    file://nss-fix-nsinstall-build.patch \
"

SRC_URI[md5sum] = "8ac87be9efeffda68750614d86946d37"
SRC_URI[sha256sum] = "989ebdf79374f24181f060d332445b1a4baf3df39d08514c4349ba8573cefa9b"
