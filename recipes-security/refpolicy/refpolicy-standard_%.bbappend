PR .= ".1"

prepare_policy_store () {
	oe_runmake 'DESTDIR=${D}' 'prefix=${D}${prefix}' install
	POL_PRIORITY=100
	POL_SRC=${D}${datadir}/selinux/${POLICY_NAME}
	POL_STORE=${D}${localstatedir}/lib/selinux/${POLICY_NAME}
	POL_ACTIVE_MODS=${POL_STORE}/active/modules/${POL_PRIORITY}

	# Prepare to create policy store
	mkdir -p ${POL_STORE}
	mkdir -p ${POL_ACTIVE_MODS}

	# get hll type from suffix on base policy module
	HLL_TYPE=$(echo ${POL_SRC}/base.* | awk -F . '{if (NF>1) {print $NF}}')
	HLL_BIN=${STAGING_DIR_NATIVE}${prefix}/libexec/selinux/hll/${HLL_TYPE}

	for i in ${POL_SRC}/*.${HLL_TYPE}; do
		MOD_NAME=$(basename $i | sed "s/\.${HLL_TYPE}$//")
		MOD_DIR=${POL_ACTIVE_MODS}/${MOD_NAME}
		mkdir -p ${MOD_DIR}
		echo -n "${HLL_TYPE}" > ${MOD_DIR}/lang_ext
		if ! bzip2 -t $i 2>/dev/null; then
			${HLL_BIN} $i | bzip2 --stdout > ${MOD_DIR}/cil
			bzip2 -f $i && mv -f $i.bz2 $i
		else
			bunzip2 --stdout $i | \
				${HLL_BIN} | \
				bzip2 --stdout > ${MOD_DIR}/cil
		fi
		cp $i ${MOD_DIR}/hll
	done
}
