
include images/imx53-basic-image.bb

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_INSTALL += " \
    nano \
    openssl \
    openssh-sftp-server \
    i2c-tools \
    openssl \
    usbutils \
    grep \
    findutils \
    gdbserver \
    rsync \
    strace \
    util-linux \
    nano \
    libosbase \
    libiotty \
    capnproto \
    udev-automount \
"

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
