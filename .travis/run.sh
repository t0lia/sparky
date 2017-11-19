#!/bin/bash
# get latest image from docker hub and restart container

docker pull t0lia/sparky:latest
docker stop sparky
docker rm sparky
docker run -d -p 80:4567 --name sparky t0lia/sparky:latest
