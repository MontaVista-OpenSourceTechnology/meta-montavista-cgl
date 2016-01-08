inherit useradd

USERADD_PACKAGES = "logcheck"
GROUPADD_PARAM_logcheck = "logcheck"

# In Ubuntu or other distro, adduser and useradd are different tools, and adduser is
# a perl script which uses the useradd binary.

#useradd options are different from adduser options.
USERADD_PARAM_${PN} = "-d /var/lib/logcheck -r -g logcheck -M logcheck \
                      "
