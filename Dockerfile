FROM amazoncorretto:11-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
CMD java $JAVA_OPTS -server -jar app.jar