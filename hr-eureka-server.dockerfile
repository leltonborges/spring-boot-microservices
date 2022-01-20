FROM openjdk:11

ENV PORT=${PORT:-8761}

WORKDIR /app

COPY hr-eureka-server/target/*.jar ./hr-eureka-server.jar

EXPOSE ${PORT}

CMD [ "java","-jar","hr-eureka-server.jar" ]
