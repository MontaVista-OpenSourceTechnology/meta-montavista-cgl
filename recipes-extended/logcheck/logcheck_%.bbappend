PR .= ".1"

inherit useradd

USERADD_PACKAGES = "logcheck"
GROUPADD_PARAM_logcheck = "logcheck"

# In Ubuntu or other distro, adduser and useradd are different tools, and adduser is
# a perl script which uses the useradd binary.

#useradd options are different from adduser options.
USERADD_PARAM_${PN} = "-d /var/lib/logcheck -r -g logcheck -M logcheck \
                      "
pkg_postinst_${PN} () {
#!/bin/sh

	if [ "x$D" != "x" ]; then
		exit 1
	fi

	chown logcheck:logcheck	/var/lib/logcheck
	chgrp -R logcheck /etc/logcheck

	/etc/init.d/populate-volatile.sh update
}

