python create_sh_wrapper_reset_alternative_vars:append () {
    #Remove Dups
    d.setVar('ALTERNATIVE:%s' % (pn), " ".join(set(d.getVar('ALTERNATIVE:%s' % (pn)).split())))
}
