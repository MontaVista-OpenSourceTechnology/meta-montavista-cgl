SAMHAIN = " \
    samhain-client \
    samhain-server \
"
SAMHAIN:riscv64 = ""

RDEPENDS:packagegroup-cgl-applications:append = " \
    ${SAMHAIN} \
"
