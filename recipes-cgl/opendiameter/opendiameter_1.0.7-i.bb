# Copyright (c) 2011 - 2015 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

DESCRIPTION = "Open source Diameter and Diameter related protocols"

SRC_URI="http://sourceforge.net/projects/diameter/files/latest/download/opendiameter-${PV}.tar.gz \
	 file://fix_error.patch \
	 file://opendiameter-install-fix.patch \
	 file://opendiameter_build_fix_with_boost_1_51_0.patch \
         file://add_needed_dependent_libs.patch \
	"

HOMEPAGE = "http://www.opendiameter.org/"
LICENSE = " LGPL-2.1 & GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ae4328207e441ccd19559ad59926864"
DEPENDS="xerces-c ace boost openssl"
PR = "r0"

inherit autotools

EXTRA_OECONF += " --enable-shared"
CXXFLAGS_append = " -fpermissive "

PARALLEL_MAKE=""

do_configure_prepend () {
    export XERCESCROOT="${STAGING_INCDIR}"
    export ACE_ROOT="${STAGING_INCDIR}"
    export BOOST_ROOT="${STAGING_INCDIR}"
}

do_install_append() {
    # The install step in the makefiles stick this in the wrong place.
    # It's hard-coded to /etc in all the C code, but has a "${prefix}"
    # in the makefiles.
    mv ${D}/usr/etc ${D}/etc
    cp -rf \
    ${S}/docs/{framework,libdiameter,libdiametereap,libdiameternasreq} \
    ${D}/usr/share/opendiameter/doc/
    cp -rf ${S}/docs/{libdiametermip4,libeap,libpana,nasreq} \
    ${D}/usr/share/opendiameter/doc/
}

SRC_URI[md5sum] = "d043fb91fdfe9aacaf282bda3929175d"
SRC_URI[sha256sum] = "1e5b135c60ebf096c3cd70db50a7ffcb6c2726067490c4318f7a767620d85dcb"
