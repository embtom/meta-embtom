SUMMARY = "EMBTOM::iotty"
DESCRIPTION = "embtom own iotty layer"
SECTION = "console/tools"
LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/tom3333/bld_iotty_linux.git;branch=master"
SRCREV = "ba7b31e173f6584a64f8807c53fd76c23a37cca1"

S = "${WORKDIR}/git/"

inherit cmake

EXTRA_OECMAKE += "\
"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${includedir} \
                   ${libdir}/cmake/*"

BBCLASSEXTEND = "native nativesdk"
