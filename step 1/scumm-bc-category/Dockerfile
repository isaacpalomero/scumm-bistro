FROM centos:centos7
RUN yum install -y epel-release
RUN yum install -y java-1.8.0-openjdk which

ADD ./build/install/scumm-bc-category-boot /opt/scumm/bc/category


WORKDIR /opt/scumm/bc/category
ENTRYPOINT ["./bin/scumm-bc-category"]


