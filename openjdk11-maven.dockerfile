FROM openjdk:11

RUN set -ex; \
    apt-get update; \
    apt-get install maven -y; \