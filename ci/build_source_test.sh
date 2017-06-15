#!/bin/bash

set -e

cd source-code
gradle --no-daemon build
mv build/libs/source-code-0.0.1-SNAPSHOT.jar ../backend_build_output/