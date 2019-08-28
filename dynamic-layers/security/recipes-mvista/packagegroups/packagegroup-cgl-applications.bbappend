SAMHAIN = " \
    samhain-client \
    samhain-server \
"
SAMHAIN_riscv64 = ""

RDEPENDS_packagegroup-cgl-applications_append = " \
    ${SAMHAIN} \
"
