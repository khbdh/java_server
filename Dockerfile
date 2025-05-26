FROM openjdk:17
COPY . /app
WORKDIR /app
RUN javac FileServer.java
CMD ["java", "FileServer"]