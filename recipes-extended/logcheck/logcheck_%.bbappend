PR .= ".2"

inherit useradd

USERADD_PACKAGES = "logcheck"
GROUPADD_PARAM_logcheck = "logcheck"

# In Ubuntu or other distro, adduser and useradd are different tools, and adduser is
# a perl script which uses the useradd binary.

#useradd options are different from adduser options.
#Add 'adm' as supplementary group for logcheck user. It is required by logcheck 
#user to read /var/log/auth.log file
USERADD_PARAM_${PN} = "-d /var/lib/logcheck -r -g logcheck -G adm -M logcheck \
                      "

do_install_append () {
    # syslog-ng is configured to capture secure and authorization
    # logs in /var/log/syslog and /var/log/auth.log respectively.
    # So, allow logcheck to check them instead of messages and secure log
    sed -i -e "s/messages/syslog/" -e "s/secure/auth\.log/" ${D}/etc/logcheck/logcheck.logfiles

    # Replace "run-parts --list" with alternate find command
    sed -i -e 's:run-parts --list "$dir":find "$dir" -maxdepth 1 -type f | sed "s|$dir/||"  | egrep "^[a-zA-Z0-9_-]+$" | sort:g' -e 's:^LOCKDIR=/run/lock/logcheck:LOCKDIR=/var/lock/logcheck:' ${D}${sbindir}/logcheck

}
pkg_postinst_${PN} () {
#!/bin/sh

	if [ "x$D" != "x" ]; then
		exit 1
	fi

	chown logcheck:logcheck /var/lib/logcheck
	chgrp -R logcheck /etc/logcheck

	/etc/init.d/populate-volatile.sh update
}

FILES_${PN} += "/var/lock/"
RDEPENDS_${PN} += "lockfile-progs"
