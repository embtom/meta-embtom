require capnproto.inc
DEPENDS = "zlib-native"

S = "${WORKDIR}/git/c++"

inherit cmake native

EXTRA_OECMAKE += "-DBUILD_TESTING=OFF -DEXTERNAL_CAPNP=off"

do_install_append () {
    mkdir -p ${D}${base_prefix}/environment-setup.d/
    script=${D}${base_prefix}/environment-setup.d/capnproto.sh
    echo 'export CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnp' >> $script
    echo 'export CAPNPC_CXX=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-c++' >> $script
    echo 'export CAPNPC_CAPNP=$OECORE_NATIVE_SYSROOT/usr/bin/capnpc-capnp' >> $script
}

SYSROOT_DIRS_NATIVE += "${bindir} ${base_prefix}/environment-setup.d"