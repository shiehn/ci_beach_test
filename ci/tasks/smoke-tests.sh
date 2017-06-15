#!/bin/bash

set -e

cat current-app-info/next-app.txt
echo "Stuff: $PWS_APP_SUFFIX $PWS_APP_DOMAIN"

cd source-code
gradle --no-daemon smokeTests