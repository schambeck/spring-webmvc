#!/usr/bin/env bash

sudo kill $(ps aux | grep 'spring-webmvc-0.0.1-SNAPSHOT.jar' | grep -v grep | awk '{print $2}')
exit 0
