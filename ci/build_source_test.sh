#!/bin/bash

cd source-code
gradle --no-daemon test

status=$?
echo "$status"
exit $status