#!/usr/bin/env groovy
package com.example

class Git implements Serializable {

  def script
  
  Git(script) {
    this.script = script
  }

  def gitConfigJenkinsUser() {
      sh 'git config --global user.name "jenkins"'
      sh 'git config --global user.email "jenkins@cicd.com"'
  }


  def gitLoginSetRepository(String repoUrl) {
      script.withCredentials([script.usernamePassword(credentialsId: 'gitlab-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh "git remote set-url origin https://$script.USER:$script.PASS@$script.repoUrl"
    }
  }


  def gitCommitVersionUpdate(String appVersion) {
      sh 'git add .'
      sh "git commit -m "CI version bump to $script.appVersion""
      sh 'git push origin HEAD:main'
  }

}