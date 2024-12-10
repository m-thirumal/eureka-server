FROM openjdk:21-jdk
LABEL author="திருமால்"
LABEL maintainer="Thirumal"

# Create a group and user using Debian-compatible commands
RUN groupadd -r thirumal && useradd -r -g thirumal thirumal

USER thirumal:thirumal
ENV APPROOT="/eureka-server-0.0.1-SNAPSHOT"
ARG DEPENDENCY=target/dependency

# Copy application files to the container
COPY ${DEPENDENCY}/BOOT-INF/lib ${APPROOT}/lib
COPY ${DEPENDENCY}/META-INF ${APPROOT}/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes ${APPROOT}

# Set entry point for the application
ENTRYPOINT ["java","-cp","eureka-server-0.0.1-SNAPSHOT:eureka-server-0.0.1-SNAPSHOT/lib/*","in.thirumal.EurekaServerApplication"]
