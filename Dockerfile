FROM openjdk:17-alpine
RUN addgroup -S thirumal && adduser -S thirumal -G thirumal
USER thirumal:thirumal
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /eureka-server-0.0.1-SNAPSHOT/lib
COPY ${DEPENDENCY}/META-INF /eureka-server-0.0.1-SNAPSHOT/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /eureka-server-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-cp","eureka-server-0.0.1-SNAPSHOT:eureka-server-0.0.1-SNAPSHOT/lib/*","in.thirumal.EurekaServerApplication"]
