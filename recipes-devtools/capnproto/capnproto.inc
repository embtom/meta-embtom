SUMMARY = "Cap'n Proto serialization/RPC system"
DESCRIPTION = "Cap’n Proto is an insanely fast data interchange format and capability-based RPC system. "
HOMEPAGE = "https://github.com/sandstorm-io/capnproto"
SECTION = "console/tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=a05663ae6cca874123bf667a60dca8c9"

#SRC_URI = "git://git@tomhp.fritz.box/3rd_repo/capnproto.git;protocol=ssh;branch=feature/yoctoSDKTOOL \
#           file://0001-initialize-anonymous-enums-in-isPlausiblyText-and-is.patch"
SRC_URI = "git://github.com/sandstorm-io/capnproto.git;branch=release-${PV} \
           file://0001-no-cmake-target-export-of-capnp_tools-if-EXTERNAL_CA.patch \
           file://0002-if-no-capnp_tools-target-exits-check-at-current-PATH.patch \
           file://0003-initialize-anonymous-enums-in-isPlausiblyText-and-is.patch"
SRCREV = "8fef9182fca584a93a1c274885cefb933d34def6"
           


