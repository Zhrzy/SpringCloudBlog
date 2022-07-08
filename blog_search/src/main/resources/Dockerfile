FROM java:alpine
VOLUME /tmp
ADD blog_search-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-Dfile.encoding=utf-8","-jar","/app.jar"]
