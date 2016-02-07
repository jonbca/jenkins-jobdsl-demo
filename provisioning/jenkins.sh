#!/usr/bin/env bash

set -ex
set -o pipefail

plugins=( git git-client junit gradle job-dsl config-file-provider token-macro jquery build-pipeline-plugin \
          parameterized-trigger dashboard-view copyartifact matrix-project junit script-security build-with-parameters \
          credentials-binding plain-credentials envinject environment-script )
jenkins_home=/var/lib/jenkins

for i in "${plugins[@]}"; do
    destination=/var/lib/jenkins/plugins/${i}.jpi
    sudo curl -SsL https://updates.jenkins-ci.org/latest/${i}.hpi > ${destination}
    chown jenkins:jenkins ${destination}
    chmod 0644 ${destination}
    echo Installed jenkins plugin ${i}
done

sudo service jenkins restart