SUMMARY = "Cap'n Proto serialization/RPC system"
DESCRIPTION = "Cap’n Proto is an insanely fast data interchange format and capability-based RPC system. "
HOMEPAGE = "https://github.com/sandstorm-io/capnproto"
SECTION = "console/tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=a05663ae6cca874123bf667a60dca8c9"

SRC_URI = "git://github.com/sandstorm-io/capnproto.git;branch=release-${PV} \
           file://0001-initialize-anonymous-enums-in-isPlausiblyText-and-is.patch"

SRCREV = "df57843543e3dd474294daa3215e99ea1814435b"

DEPENDS = "zlib"
DEPENDS_append_class-target += " capnproto-native"

S = "${WORKDIR}/git/c++"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_TESTING=OFF"
EXTRA_OECMAKE_append_class-target += "-DBUILD_SHARED_LIBS=on -DEXTERNAL_CAPNP=on"
EXTRA_OECMAKE_append_class-native += "-DEXTERNAL_CAPNP=on"
EXTRA_OECMAKE_append_class-nativesdk += "-DEXTERNAL_CAPNP=on"


do_install_append_class-nativesdk () {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d/
    script=${D}${SDKPATHNATIVE}/environment-setup.d/capnproto.sh
    echo 'export CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnp' >> $script
    echo 'export CAPNPC_CXX=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-c++' >> $script
    echo 'export CAPNPC_CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-capnp' >> $script
}

do_install_append_class-target() {
    sed -i 's/"${_IMPORT_PREFIX}\/bin\/capnp"/"$ENV{CAPNP}"/g' ${D}/usr/lib/cmake/CapnProto/CapnProtoTargets-noconfig.cmake
    sed -i 's/"${_IMPORT_PREFIX}\/bin\/capnpc-c++"/"$ENV{CAPNPC_CXX}"/g' ${D}/usr/lib/cmake/CapnProto/CapnProtoTargets-noconfig.cmake
    sed -i 's/"${_IMPORT_PREFIX}\/bin\/capnpc-capnp"/"$ENV{CAPNPC_CAPNP}"/g' ${D}/usr/lib/cmake/CapnProto/CapnProtoTargets-noconfig.cmake
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-compiler = "${bindir}"
FILES_${PN}-dev = " ${includedir} \
                    ${libdir}/pkgconfig \
                    ${libdir}/cmake \
                    ${libdir}/lib*.so"
FILES_${PN}-compiler_append_class-nativesdk = " ${SDKPATHNATIVE}/environment-setup.d/capnproto.sh"


PACKAGE_BEFORE_PN = "${PN}-compiler"

#RDEPENDS_${PN}-dev += "${PN}-compiler"

BBCLASSEXTEND = "native nativesdk"
