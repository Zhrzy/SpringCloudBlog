FROM java:alpine
VOLUME /tmp
ADD blog_picture-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-Dfile.encoding=utf-8","-jar","/app.jar"]
