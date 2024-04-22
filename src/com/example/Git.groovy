#!/usr/bin/env groovy
package com.example

class Git implements Serializable {

  def script
  
  Git(script) {
    this.script = script
  }

  def gitConfigJenkinsUser() {
      script.sh 'git config --global user.name "jenkins"'
      script.sh 'git config --global user.email "jenkins@cicd.com"'
  }


  def gitLoginSetRepository() {
      script.withCredentials([script.usernamePassword(credentialsId: 'gitlab-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      script.sh "git remote set-url origin https://$script.USER:$script.PASS@gitlab.com/fieryybird/bootcamp-jenkins-homework.git"
    }
  }


  def gitCommitVersionUpdate() {
      script.sh 'git add .'
      script.sh 'git commit -m "CI version bump"'
      script.sh 'git push origin HEAD:main'
  }

}