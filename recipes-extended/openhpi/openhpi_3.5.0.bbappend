PR .= ".1"

do_configure_prepend_class-target () {
    ${CC} -dM -E - < /dev/null > output
    export OH_SIZEOF_UCHAR=$(expr $(cat output | grep __CHAR_BIT__ | gawk -F " " '{print $3}') \/ 8)
    export OH_SIZEOF_USHORT=$(cat output | grep __SIZEOF_SHORT__ | gawk -F " " '{print $3}')
    export OH_SIZEOF_UINT=$(cat output | grep __SIZEOF_INT__ | gawk -F " " '{print $3}')
    export OH_SIZEOF_CHAR=$OH_SIZEOF_UCHAR
    export OH_SIZEOF_SHORT=$OH_SIZEOF_USHORT
    export OH_SIZEOF_INT=$OH_SIZEOF_UINT
    export OH_SIZEOF_LLONG=$(cat output | grep __SIZEOF_LONG_LONG__ | gawk -F " " '{print $3}')
    export OH_SIZEOF_FLOAT=$(cat output | grep __SIZEOF_FLOAT__ | gawk -F " " '{print $3}')
    export OH_SIZEOF_DOUBLE=$(cat output | grep __SIZEOF_DOUBLE__ | gawk -F " " '{print $3}')
}
