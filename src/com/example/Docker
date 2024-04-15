#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

  def script
  
  Docker(script) {
    this.script = script
  }

  def buildDockerImage(String imageName) {
        script.echo "building the Docker Image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login 37.187.124.95:8888 -u $script.USER --password-stdin"
            script.sh "docker push $imageName"
    }
  }
}

