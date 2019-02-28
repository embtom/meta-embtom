SUMMARY = "Cap'n Proto serialization/RPC system"
DESCRIPTION = "Cap’n Proto is an insanely fast data interchange format and capability-based RPC system. "
HOMEPAGE = "https://github.com/sandstorm-io/capnproto"
SECTION = "console/tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=a05663ae6cca874123bf667a60dca8c9"

SRC_URI = "git://github.com/capnproto/capnproto.git;branch=release-${PV}"
SRCREV = "3f44c6db0f0f6c0cab0633f15f15d0a2acd01d19"

EXTRA_OECMAKE += "\
    -DBUILD_TESTING=OFF \
"


S = "${WORKDIR}/git/c++"

inherit cmake

EXTRA_OECMAKE += "\
    -DBUILD_TESTING=OFF \
"
ALLOW_EMPTY_${PN} = "1"
FILES_${PN} += "${libdir}/*"
FILES_${PN}-dev += "${libdir}/cmake"
FILES_${PN}-staticdev += "${libdir}/*"
FILES_${PN}-compiler = "${bindir}"

PACKAGE_BEFORE_PN = "${PN}-compiler"
RDEPENDS_${PN}-dev += "${PN}-compiler ${PN}-staticdev"

BBCLASSEXTEND = "native nativesdk"
