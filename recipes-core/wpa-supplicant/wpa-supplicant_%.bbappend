FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://wpa_supplicant_emb.conf"

do_install_append_raspberrypi() {
install -m 600 ${WORKDIR}/wpa_supplicant_emb.conf ${D}${sysconfdir}/wpa_supplicant.conf
}

do_install_append_imx6-cubox() {
install -m 600 ${WORKDIR}/wpa_supplicant_emb.conf ${D}${sysconfdir}/wpa_supplicant.conf
}