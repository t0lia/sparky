#!/bin/bash
docker build -t giantswarm/sparkexample .
docker run -d -p 4567:4567 giantswarm/sparkexample
