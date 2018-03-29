PR .= ".1"

inherit multilib-alternatives

MULTILIB_ALTERNATIVES_${PN} = "/etc/apache2/modules.d/wsgi.load"
