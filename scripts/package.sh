#!/usr/bin/env bash

cd /home/ec2-user/app/target
sudo ./mvnw clean package -DskipTests
