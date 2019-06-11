SUMMARY = "Demo applicaton to test 3D graphics using kms and gbm"
HOMEPAGE = "https://cgit.freedesktop.org/mesa/kmscube/"
LICENSE = "MIT"
SECTION = "graphics"
DEPENDS = "virtual/libgles2 virtual/egl libdrm"

LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=8b309d4ee67b7315ff7381270dd631fb"

SRC_URI = "git://github.com/embtom/kmscube.git;branch=master \
           file://change_default_card.patch"

SRCREV = "5b3d5dd9a6fb71f2ecdfee7f3cbeedbe8ba59f64"

S = "${WORKDIR}/git/"

inherit cmake

FILES_${PN} += "${bindir}"
