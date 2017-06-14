#!/bin/bash

cd source-code
gradle --no-daemon build
cp build/libs/ci_beach_test-0.0.1-SNAPSHOT.jar ../backend_build_output/
cp manifest.yml ../backend_build_output/manifest.yml

ls ../backend_build_output