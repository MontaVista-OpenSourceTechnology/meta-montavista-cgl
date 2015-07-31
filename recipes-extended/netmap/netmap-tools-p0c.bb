require netmap-tools-p0c.inc

SRC_URI = "http://info.iet.unipi.it/~luigi/doc/20131019-netmap.tgz"

SRC_URI[md5sum] = "ff0d01ef0c56e12fd227e40755afc5ca"
SRC_URI[sha256sum] = "4cc55ef379fdc9483a6a61ec938d4df5f717843e5d3168935387385d33fdde38"

SRC_URI +=" \
		file://0001-netmap-support-xgene-enet.patch \
		"

COMPATIBLE_MACHINE = "(apm-magneto-p0c|armeb-cortex-a15|apm-magneto-p1a-le)"
