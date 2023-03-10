FROM adoptopenjdk/openjdk11:latest
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY target/exchange-rate-bcp-0.0.1-SNAPSHOT.jar /opt/app/target/
EXPOSE 8080
CMD ["sh", "-c", "java -jar /opt/app/target/exchange-rate-bcp-0.0.1-SNAPSHOT.jar"]