FROM openjdk:11

ENV GITHUB_USER=${GITHUB_USERNAME:-leltondev}
ENV GITHUB_PASS=${GITHUB_PASSWD:-G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}
ENV PORT=${PORT:-8888}

WORKDIR /app

COPY hr-config-server/target/*.jar ./hr-config-server.jar

EXPOSE 8888

CMD [ "java","-jar","hr-config-server.jar" ]
