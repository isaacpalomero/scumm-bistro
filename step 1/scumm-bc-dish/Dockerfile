FROM centos:centos7
RUN yum install -y epel-release
RUN yum install -y java-1.8.0-openjdk which

ADD ./build/install/scumm-bc-dish-boot /opt/scumm/bc/dish


WORKDIR /opt/scumm/bc/dish
ENTRYPOINT ["./bin/scumm-bc-dish"]


