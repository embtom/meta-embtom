FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_raspberrypi = " file://interfaces \
                  file://networking \
                  "
SRC_URI_append_imx53 = " file://interfaces_imx53"

do_install_append_raspberrypi() {
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
    install -m 0755 ${WORKDIR}/networking ${D}${sysconfdir}/init.d/networking
}

do_install_append_imx53() {
    install -m 0644 ${WORKDIR}/interfaces_imx53 ${D}${sysconfdir}/network/interfaces
}