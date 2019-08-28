
LM_SENSORS = " \
    lmsensors-fancontrol \
    lmsensors-libsensors \
    lmsensors-pwmconfig \
    lmsensors-sensord \
    lmsensors-sensors \
    lmsensors-sensorsconfconvert \
    lmsensors-sensorsdetect \
    lmsensors-config-cgi \
    lmsensors-config-libsensors \
    lmsensors-config-sensord \
    lmsensors-config-fancontrol \
"
MAKEDUMPFILE = "makedumpfile"
MAKEDUMPFILE_riscv64 = ""
CRASH = "crash"
CRASH_riscv64 = "" 
RDEPENDS_packagegroup-cgl-applications_append = " \
	${LM_SENSORS} \
	smartmontools \
	${CRASH} \
	${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'pam-passwdqc', '', d)} \
	rsyslog \
    ${MAKEDUMPFILE} \
"
