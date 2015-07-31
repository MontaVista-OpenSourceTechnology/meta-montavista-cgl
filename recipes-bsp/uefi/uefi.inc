PN="uefi"

PACKAGE_ARCH="${MACHINE_ARCH}"

DESCRIPTION="UEFI - Unified Extensible Firmware Interface"
HOMEPAGE="https://wiki.linaro.org/ARM/UEFI"

SRC_URI = "git://git.linaro.org/arm/uefi/uefi.git;protocol=git \
           file://uefi-build.sh \
          "

PR .= ".2"

inherit deploy

S = "${WORKDIR}/git"

LICENSE = "LGPLv2"

LIC_FILES_CHKSUM ?= "file://ArmPkg/License.txt;md5=9246519a5aad2d1a83cf822b5b543cdb"

DEPENDS += "util-linux-native"

do_compile() {
   if [ "x${UEFI_TARGET}" == "x" ] ; then
	echo "You must set UEFI_TARGET"
	exit 1
   fi
   sed -i "s/-Werror//g" BaseTools/Source/C/Makefiles/header.makefile
   ${WORKDIR}/uefi-build.sh ${UEFI_TARGET} 
}
UEFI_SUFFIX ?= "bin"
UEFI_IMAGE ?= "uefi-${MACHINE}-${PV}-${PR}.${UEFI_SUFFIX}"
UEFI_BINARY ?= "uefi.${UEFI_SUFFIX}"
UEFI_SYMLINK ?= "uefi-${MACHINE}.${UEFI_SUFFIX}"
UEFI_TARGET_FILE ?= ""
UEFI_TARGET ?= ""

do_deploy() {
   if [ "x${UEFI_TARGET_FILE}" == "x" ] ; then
	echo "You must set UEFI_TARGET_FILE"
	exit 1
   fi
   install -d ${DEPLOYDIR}
   install ${S}/${UEFI_TARGET_FILE} ${DEPLOYDIR}/${UEFI_IMAGE}
   cd ${DEPLOYDIR}
   rm -f ${UEFI_BINARY} ${UEFI_SYMLINK}
   ln -sf ${UEFI_IMAGE} ${UEFI_SYMLINK}
   ln -sf ${UEFI_IMAGE} ${UEFI_BINARY}
}

do_install () {
	mkdir -p ${D}/boot
	install ${S}/${UEFI_TARGET_FILE} ${D}/boot/${UEFI_IMAGE}
}

FILES_${PN} = "/boot/${UEFI_IMAGE}"

addtask deploy before do_build after do_compile
