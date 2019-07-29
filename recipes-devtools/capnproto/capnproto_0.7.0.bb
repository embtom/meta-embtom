require capnproto.inc

DEPENDS = "zlib"
DEPENDS_prepend = "capnproto-native "

S = "${WORKDIR}/git/c++"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_TESTING=OFF"
EXTRA_OECMAKE_append_class-target += "-DBUILD_SHARED_LIBS=on -DEXTERNAL_CAPNP=on"
EXTRA_OECMAKE_append_class-nativesdk += "-DEXTERNAL_CAPNP=off"

do_install_append_class-nativesdk () {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d/
    script=${D}${SDKPATHNATIVE}/environment-setup.d/capnproto.sh
    echo 'export CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnp' >> $script
    echo 'export CAPNPC_CXX=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-c++' >> $script
    echo 'export CAPNPC_CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-capnp' >> $script
}

FILES_${PN}-compiler = "${bindir}"
FILES_${PN}-compiler_append_class-nativesdk = " ${SDKPATHNATIVE}/environment-setup.d/capnproto.sh"

PACKAGE_BEFORE_PN = "${PN}-compiler"
BBCLASSEXTEND = "nativesdk"
