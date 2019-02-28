SUMMARY = "EMBTOM::osbase"
DESCRIPTION = "embtom own osbase layer"
SECTION = "console/tools"
LICENSE = "CLOSED"

SRC_URI = "gitsm://github.com/tom3333/bld_osbase_linux.git;branch=master"
SRCREV = "a2f07c7c4feb8b8b4c949ac68d06ffa3ee246941"

S = "${WORKDIR}/git/"

inherit cmake

EXTRA_OECMAKE += "-DLIB_LIST_LOCK=lock_mtx"

DEPENDS = "libiotty"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${includedir} \
                   ${libdir}/cmake/*"

BBCLASSEXTEND = "native nativesdk"
