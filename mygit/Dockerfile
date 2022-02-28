FROM centos:7
MAINTAINER sadocode <sadocode92@gmail.com>

# install git
RUN yum -y update
RUN yum -y install vim
RUN yum -y install git
RUN yum -y install net-tools

# korean setting
RUN localedef -f UTF-8 -i ko_KR kor_KR.utf8 && ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
ENV LANG ko_KR.utf8
ENV LC_ALL ko_KR.utf8
COPY ./yum.conf /etc/yum.conf
RUN yum -y reinstall glibc-common

# volume setting
RUN mkdir /home/volume
VOLUME ["/home/volume"]

CMD ["/bin/bash"]

# open container port
EXPOSE 19932
