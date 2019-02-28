# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_FEATURES += "eclipse-debug tools-debug"


IMAGE_INSTALL += " \
     kernel-modules \
     linux-firmware \
     nano \
     openssl \
     i2c-tools \
     mtd-utils \
     net-tools \
     openssl \
     usbutils \
     grep \
     findutils \
     gdbserver \
     rsync \
     strace \
     userland \
     openhab\
     xserver-xorg\
     xserver-xf86-config\
     xf86-input-keyboard\
     xkeyboard-config\
     util-linux \
     libosbase \
     libiotty \
     capnproto \
     "
     
#     capnproto \
#

CORE_IMAGE_EXTRA_INSTALL += "wpa-supplicant"
#CORE_IMAGE_EXTRA_INSTALL += "wireless-tools"
#CORE_IMAGE_EXTRA_INSTALL += "modutils-initscripts"
     
IMAGE_OVERHEAD_FACTOR = "2"   
#TOOLCHAIN_HOST_TASK_append += "nativesdk-cmake"

TOOLCHAIN_HOST_TASK_append = " \
     nativesdk-cmake-dev \
"

TOOLCHAIN_TARGET_TASK_append = " \
     kernel-devsrc \
     util-linux-dev \
     libosbase-dev \
     libiotty-dev \
     capnproto-dev\
"
