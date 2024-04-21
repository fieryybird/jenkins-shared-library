#!/usr/bin/env groovy
package com.example

class Npm implements Serializable {

  def script
  
  Npm(script) {
    this.script = script
  }

  
  def npmInstall() {
    script.sh 'npm install'
  }
  
  def npmTest() {
    script.sh 'npm test'
  }

  def npmRemoveNodeModules() {
    script.sh 'rm -rf node_modules'
  }

  def npmVersionUpdateMajor() {
    script.sh 'npm version major --no-git-tag-version'
  }

  def npmVersionUpdateMinor() {
    script.sh 'npm version minor --no-git-tag-version'
  }

  def npmVersionUpdatePatch() {
    script.sh 'npm version patch --no-git-tag-version'
  }

}