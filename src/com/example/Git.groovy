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


  def gitSetRepository(String git_credentials, String repoUrl) {
      script.withCredentials([script.usernamePassword(credentialsId: git_credentials, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      script.sh "git remote set-url origin https://$script.USER:$script.PASS@$repoUrl"
    }
  }


  def gitCommitVersionUpdate(String version) {
      script.sh 'git add .'
      script.sh "git commit -m 'CI version bump to $version'"
      script.sh 'git push origin HEAD:main'
  }

}