#!/bin/bash
docker stop sparky
docker container prune -f
docker build -t giantswarm/sparkexample .
docker run -d -p 8080:4567 --name sparky giantswarm/sparkexample
