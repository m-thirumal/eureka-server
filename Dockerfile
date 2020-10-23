FROM openjdk:15-alpine
LABEL author="திருமால்"
LABEL maintainer="Thirumal"
RUN addgroup -S thirumal && adduser -S thirumal -G thirumal
USER spring:spring