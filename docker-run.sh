#!/usr/bin/env bash

JAVA_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n -Djava.security.egd=file:/dev/./urandom"
java ${JAVA_OPTIONS} -jar "elections.jar"
