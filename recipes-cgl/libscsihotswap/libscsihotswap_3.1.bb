# 2010,2012 (c) MontaVista Software, LLC.
#
# Released under BSD license, the text of which follows:
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# - Redistributions of source code must retain the above copyright notice,
#   this list of conditions and the following disclaimer.
# - Redistributions in binary form must reproduce the above copyright notice,
#   this list of conditions and the following disclaimer in the documentation
#   and/or other materials provided with the distribution.
# - Neither the name of the MontaVista Software, LLC. nor the names of its
#   contributors may be used to endorse or promote products derived from this
#   software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
# AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
# IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
# ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
# CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
# SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
# INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
# CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
# ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
# THE POSSIBILITY OF SUCH DAMAGE.

DESCRIPTION = "Software library for accessing the SCSI/FC hotswap interface"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4c1344207587ecb746c1619a85ee32f0"
PR = "r3"

SRC_URI = "git://github.com/MontaVista-OpenSourceTechnology/libscsihotswap.git;protocol=https \
	"
S = "${WORKDIR}/git"
#Version 3.1
SRCREV = "634b496d4eef0d020f67fd8f846878bc91b6cdae"
EXTRA_OEMAKE = ""
TARGET_CC_ARCH += "${LDFLAGS}"
ASNEEDED=""

do_compile () {
	pushd libscsihotswap
        oe_runmake
	popd
	pushd scsi_hotswap_cmd
	oe_runmake
	popd
}

do_install () {
        # the library
        install -m 755 -d ${D}${libdir}
	install -m 755 -d ${D}${includedir}
	install -m 755 -d ${D}${mandir}/man3
	pushd libscsihotswap
        install -m 0755 libscsihotswap.so.1.1 ${D}${libdir}
	pushd ${D}${libdir}
	ln -s libscsihotswap.so.1.1 libscsihotswap.so
	ln -s libscsihotswap.so.1.1 libscsihotswap.so.1
	popd
	install -m 0644 libscsihotswap.a ${D}${libdir}
	install -m 0644 libscsihotswap.h ${D}${includedir}
	gzip -nc scsi_hotswap_by_id.3 > ${D}${mandir}/man3/scsi_hotswap_by_id.3.gz
	gzip -nc scsi_hotswap_by_ieee_wildcard.3 > ${D}${mandir}/man3/scsi_hotswap_by_ieee_wildcard.3.gz
	popd

	# the utilities
	install -m 755 -d ${D}${sbindir}
	pushd scsi_hotswap_cmd
	install -m 0755 scsi_hotswap_cmd ${D}${sbindir}
	pushd ${D}${sbindir}
	ln -s scsi_hotswap_cmd scsi_blkdev_remove_by_id
	ln -s scsi_hotswap_cmd scsi_blkdev_remove_by_wwn_wildcard
	ln -s scsi_hotswap_cmd scsi_hotinsert_by_id
	ln -s scsi_hotswap_cmd scsi_hotinsert_by_wwn_wildcard
	ln -s scsi_hotswap_cmd scsi_hotremove_by_id
	ln -s scsi_hotswap_cmd scsi_hotremove_by_wwn_wildcard
	popd
	popd
}


