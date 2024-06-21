FROM openjdk:21-jdk
LABEL author="திருமால்"
LABEL maintainer="Thirumal"
RUN addgroup -S thirumal && adduser -S thirumal -G thirumal
USER thirumal:thirumal
ENV APPROOT="/eureka-server-0.0.1-SNAPSHOT"
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib ${APPROOT}/lib
COPY ${DEPENDENCY}/META-INF ${APPROOT}/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes ${APPROOT}
ENTRYPOINT ["java","-cp","eureka-server-0.0.1-SNAPSHOT:eureka-server-0.0.1-SNAPSHOT/lib/*","in.thirumal.EurekaServerApplication"]
