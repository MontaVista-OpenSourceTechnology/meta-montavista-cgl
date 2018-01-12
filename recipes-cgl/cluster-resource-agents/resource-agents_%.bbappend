inherit multilib-alternatives

MULTILIB_ALTERNATIVES_${PN} += "${datadir}/resource-agents/ocft/caselib \
                                ${sbindir}/ocf-tester \
                                ${sysconfdir}/ha.d/shellfuncs \
"

