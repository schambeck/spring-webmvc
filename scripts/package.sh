#!/usr/bin/env bash

cd /home/ec2-user/app
sudo ./mvnw clean package -DskipTests
