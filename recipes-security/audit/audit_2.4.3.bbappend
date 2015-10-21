PR .= ".1"

# ugly workaround to fix referring older bits/socket.h header file
# in centos 5.6, which doesn't have new macros such as AF_RDS,
# AF_LLC, AF_CAN  defined.
# bits/socket.h is given by host glibc, since we 
# don't have an option to upgrade glibc for chroot slave; falling
# back to link with target's header file.
BUILD_CFLAGS += " -isystem${STAGING_INCDIR} "
