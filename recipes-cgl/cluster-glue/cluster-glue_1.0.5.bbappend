# This file modifies hardcoded strings such as /usr/lib, /etc, /usr/share strings 
# to generalized form
PR .= ".1"

do_install_append () {
    sed -i -e '1s,#!.*python,#!${bindir}/env python,' ${D}${libdir}/stonith/plugins/stonith2/ribcl.py
}

FILES_${PN} = "${sysconfdir} ${localstatedir} ${libdir}/lib*.so.* \
        ${sbindir} ${datadir}/cluster-glue/*sh ${datadir}/cluster-glue/*pl\
	${libdir}/heartbeat/transient-test.sh \
	${libdir}/heartbeat/logtest \
	${libdir}/heartbeat/ipctransientserver \
	${libdir}/heartbeat/base64_md5_test \
	${libdir}/heartbeat/ipctest \
	${libdir}/heartbeat/ipctransientclient \
	${libdir}/heartbeat/ha_logd \
	${libdir}/heartbeat/lrmd \
	"

FILES_${PN}-dbg += "${libdir}/heartbeat/.debug/"

FILES_${PN}-plugin-test = "${libdir}/heartbeat/plugins/test/test.so"
FILES_${PN}-plugin-test-staticdev = "${libdir}/heartbeat/plugins/test/test.*a"
FILES_${PN}-plugin-test-dbg = "${libdir}/heartbeat/plugins/test/.debug/"
FILES_${PN}-plugin-stonith2 = " \
	${libdir}/stonith/plugins/xen0-ha-dom0-stonith-helper \
	${libdir}/stonith/plugins/stonith2/*.so \
	"
FILES_${PN}-plugin-stonith2-ribcl = "${libdir}/stonith/plugins/stonith2/ribcl.py"

FILES_${PN}-plugin-stonith2-dbg = "${libdir}/stonith/plugins/stonith2/.debug/"
FILES_${PN}-plugin-stonith2-staticdev = "${libdir}/stonith/plugins/stonith2/*.*a"

FILES_${PN}-plugin-stonith-external = "${libdir}/stonith/plugins/external/"
FILES_${PN}-plugin-raexec = "${libdir}/heartbeat/plugins/RAExec/*.so"
FILES_${PN}-plugin-raexec-staticdev = "${libdir}/heartbeat/plugins/RAExec/*.*a"
FILES_${PN}-plugin-raexec-dbg = "${libdir}/heartbeat/plugins/RAExec/.debug/"

FILES_${PN}-plugin-interfacemgr = "${libdir}/heartbeat/plugins/InterfaceMgr/generic.so"
FILES_${PN}-plugin-interfacemgr-staticdev = "${libdir}/heartbeat/plugins/InterfaceMgr/generic.*a"
FILES_${PN}-plugin-interfacemgr-dbg = "${libdir}/heartbeat/plugins/InterfaceMgr/.debug/"
