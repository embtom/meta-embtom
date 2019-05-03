SUMMARY = "EMBTOM::iotty"
DESCRIPTION = "embtom own iotty layer"
SECTION = "console/tools"
LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/tom3333/bld_iotty_linux.git;branch=master"
SRCREV = "b875809deeb85afb289e6bc6072550b66ebfb31b"

S = "${WORKDIR}/git/"

inherit cmake

EXTRA_OECMAKE += "\
"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${includedir} \
                   ${libdir}/cmake/*"

BBCLASSEXTEND = "native nativesdk"
