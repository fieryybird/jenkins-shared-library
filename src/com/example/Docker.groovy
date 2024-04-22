#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

  def script
  
  Docker(script) {
    this.script = script
  }

   def dockerLoginHub() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
  }

  def dockerLoginNexus() {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login 37.187.124.95:8888 -u $script.USER --password-stdin"
    }
  }

  def dockerBuild(String imageName) {
            script.sh "docker build -t $imageName ."
    }
  
  def dockerPush(String imageName) {
            script.sh "docker push $imageName"
    }

  def dockerRemoveImage(String imageName) {
            script.sh "docker rmi $imageName"
    }


}