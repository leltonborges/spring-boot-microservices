FROM openjdk11-maven:v1

ENV HR_CONFIG_SERVER=${HOST_CONFIG_SERVER}
ENV HR_CONFIG_PORT=${HOST_CONFIG_PORT}
ENV HR_EUREKA_SERVER=${HOST_EUREKA_SERVER}
ENV HR_EUREKA_PORT=${HOST_EUREKA_PORT}

WORKDIR /app

COPY hr-Oauth/ ./

RUN set -ex; \
    mvn clean package -DskipTests; \
    cp target/*.jar ./oauth.jar;

CMD [ "java","-jar","oauth.jar" ]
