FROM eclipse-temurin:20-jdk

ARG GRADLE_VERSION=8.2

WORKDIR /project

COPY . .

RUN apt-get update && apt-get install -yq make unzip

RUN apt-get install -y tree

RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
&& unzip gradle-${GRADLE_VERSION}-bin.zip \
&& rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN mv gradle-${GRADLE_VERSION} ${GRADLE_HOME}

EXPOSE 8080