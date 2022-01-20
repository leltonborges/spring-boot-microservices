FROM openjdk11-maven:v1

ENV HR_CONFIG_SERVER=${HOST_CONFIG_SERVER}
ENV HR_CONFIG_PORT=${HOST_CONFIG_PORT}
ENV HR_EUREKA_SERVER=${HOST_EUREKA_SERVER}
ENV HR_EUREKA_PORT=${HOST_EUREKA_PORT}
ENV PORT=${PORT}

WORKDIR /app

EXPOSE ${PORT}

COPY hr-api-gateway-zuul/ ./

RUN set -ex; \
    mvn clean package -DskipTests; \
    cp target/*.jar ./gateway-zuul.jar;

CMD [ "java","-jar","gateway-zuul.jar" ]
