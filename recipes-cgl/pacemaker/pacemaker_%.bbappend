inherit multilib-alternatives

MULTILIB_ALTERNATIVES_${PN} = "${datadir}/pacemaker/tests/coverage.sh \
                               ${datadir}/pacemaker/tests/lrmd/regression.py \
                               ${datadir}/pacemaker/tests/pengine/regression.core.sh \
"
