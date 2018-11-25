inherit multilib_script

MULTILIB_SCRIPTS = "${PN}:${datadir}/resource-agents/ocft/caselib \
                    ${PN}:${sbindir}/ocf-tester \
                    ${PN}:${sysconfdir}/ha.d/shellfuncs \
"
