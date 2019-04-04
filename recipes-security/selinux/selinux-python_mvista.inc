do_install() {
        oe_runmake DESTDIR=${D} \
                PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
                LIBDIR='${D}${libdir}' \
                install
}

