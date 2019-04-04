require ${@bb.utils.contains('DISTRO_FEATURES', 'mvista-cgl', '${BPN}_mvista.inc', '', d)}
