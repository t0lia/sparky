#!/bin/bash
# rebuilt and restart container

docker stop sparky
docker rm sparky
docker build -t giantswarm/sparkexample .
docker run -d -p 8080:4567 --name sparky giantswarm/sparkexample
