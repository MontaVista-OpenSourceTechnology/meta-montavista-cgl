PR .= ".1"

inherit multilib_script

MULTILIB_SCRIPTS = "${PN}:/etc/apache2/modules.d/wsgi.load"
