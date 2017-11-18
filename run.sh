#!/bin/bash
docker build -t giantswarm/sparkexample .
docker run -d -p 8080:4567 --name sparky giantswarm/sparkexample
