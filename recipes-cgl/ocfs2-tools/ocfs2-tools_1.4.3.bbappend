PR .= ".1"

# IP do provide compile_et, but its variables contain 
# paths pointing to location where IP has been built.
# So pull in e2fsprogs-native
DEPENDS += "e2fsprogs-native"

SRC_URI[md5sum] = "299191b04ced0d5f71670c799314e684"
SRC_URI[sha256sum] = "6ccac6910f2b91f79326b06f02b8760de863ba881335757063100823b910a45f"
