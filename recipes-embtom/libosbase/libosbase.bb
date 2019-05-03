SUMMARY = "EMBTOM::osbase"
DESCRIPTION = "embtom own osbase layer"
SECTION = "console/tools"
LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/tom3333/bld_osbase_linux.git;branch=master"
SRCREV = "65a45190e22ca57ecbcb72e4dabf04488951bae7"

S = "${WORKDIR}/git/"

inherit cmake

EXTRA_OECMAKE += "-DLIB_LIST_LOCK=lock_mtx"

DEPENDS = "libiotty"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${includedir} \
                   ${libdir}/cmake/*"

BBCLASSEXTEND = "native nativesdk"
