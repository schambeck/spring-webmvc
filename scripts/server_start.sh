#!/usr/bin/env bash

cd /home/ec2-user/app/target
sudo java -jar spring-webmvc-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &
