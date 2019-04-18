#!/bin/bash

# 在javaBasic主目录执行

set -ue

mvn sonar:sonar \
  -Dsonar.projectKey=test \
  -Dsonar.host.url=http://140.143.250.99:8888 \
  -Dsonar.login=cf4262137b6ade187de4461aab3fb89effd2c72c