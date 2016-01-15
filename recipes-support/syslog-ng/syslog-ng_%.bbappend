PR .= ".1"

do_install_append () {
    # The upstream syslog-ng recipe sets localstatedir to
    # '${localstatedir}/lib/${BPN}', this is the directory where
    # syslog-ng.pid file is created. But the syslog-ng initscript
    # (/etc/init.d/syslog.syslog-ng) tries to find pid file in 
    # '${localstatedir}/run/${BPN}' directory, causing unable to
    # stop running syslog-ng daemon.
    # Hence set PIDFILE to ${localstatedir}/lib/${BPN}/syslog-ng.pid
    sed -i "s:^PIDFILE=.*:PIDFILE=${localstatedir}/lib/${BPN}/syslog-ng.pid:g" \
    ${D}/${sysconfdir}/init.d/syslog.${BPN}
}
