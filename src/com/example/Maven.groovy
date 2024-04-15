#!/usr/bin/env groovy
package com.example

class Maven implements Serializable {

  def script
  
  Maven(script) {
    this.script = script
  }

  
  def mavenBuild() {
    script.sh 'mvn package'
  }
  
}