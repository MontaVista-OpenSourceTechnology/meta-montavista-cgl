RDEPENDS_selinux-python-audit2allow += "\
        python-textutils \
        libselinux-python \
        ${PN}-sepolgen \
"
RDEPENDS_selinux-python-chcat += "\
        python-codecs \
        python-shell \
        python-stringold \
        python-unixadmin \
        libselinux-python \
        ${PN} \
"
RDEPENDS_selinux-python += "\
        python-codecs \
        python-io \
        python-ipy \
        python-re \
        python-stringold \
        python-syslog \
        python-unixadmin \
        libselinux-python \
        libsemanage-python \
        setools \
"
RDEPENDS_selinux-python-semanage += "\
        python-core \
        python-ipy \
        python-compression \
        python-xml \
        libselinux-python \
        ${PN} \
"
RDEPENDS_selinux-python-sepolicy += "\
        python-argparse \
        python-codecs \
        python-core \
        python-syslog \
        ${PN} \
"
RDEPENDS_selinux-python-sepolgen-ifgen += "\
        python \
        libselinux-python \
"
do_install() {
        oe_runmake DESTDIR=${D} \
                PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
                LIBDIR='${D}${libdir}' \
                install
}

