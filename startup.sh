#!/usr/bin/env bash

mvn clean package

docker build -t ancina/scores .

docker run -d -p 8083:8083 -t ancina/scores