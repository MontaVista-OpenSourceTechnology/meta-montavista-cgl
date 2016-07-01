PR .= ".3"

# IP do provide compile_et, but its variables contain 
# paths pointing to location where IP has been built.
# So pull in e2fsprogs-native
DEPENDS += "e2fsprogs-native"
