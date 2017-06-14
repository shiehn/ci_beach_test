#!/bin/bash

cd source-code
gradle --no-daemon build 
mv build/libs/* ../backend_build_output/
cp manifest.yml ../backend_build_output/manifest.yml