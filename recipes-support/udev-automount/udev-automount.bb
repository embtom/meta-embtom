SUMMARY = "usb automount"
DESCRIPTION = "udev rule for mounting"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://11-usb-automount.rules"

S="${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/udev/rules.d
    install -m 644 ${S}/11-usb-automount.rules ${D}/${sysconfdir}/udev/rules.d
}

FILES_${PN} = "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"
CONFFILES_${PN}=""