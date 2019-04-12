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

RDEPENDS_packagegroup-cgl-applications_append = " \
	${LM_SENSORS} \
	smartmontools \
	crash \
	pam-passwdqc \
	rsyslog \
	makedumpfile \
"
