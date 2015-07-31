DESCRIPTION = "Tool for handling kdump dumps"
SECTION = "kernel/userland"
HOMEPAGE = "https://github.com/cminyard/kdump-tool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bae3019b4c6dc4138c217864bd04331f"
PR = "r2"
SRC_URI = "https://github.com/cminyard/kdump-tool/releases/download/v1.0.0/kdump-tool-1.0.0.tar.gz"

SRC_URI += "file://0001-Allow-the-output-file-to-be-stdout.patch"

inherit autotools

BBCLASSEXTEND += "native"
DEPENDS += "elfutils"
SRC_URI[md5sum] = "013496026cd59a79aff1a65f934a1b31"
SRC_URI[sha256sum] = "2101d52a1b639adb1306cc2160f24ccf12364d95c49b80e615c625240ff378b1"

