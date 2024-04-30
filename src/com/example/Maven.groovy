#!/usr/bin/env groovy
package com.example

class Maven implements Serializable {

  def script
  
  Maven(script) {
    this.script = script
  }

  def mavenTest() {
    script.sh 'mvn test'  
  }
  
  def mavenBuild() {
    script.sh 'mvn clean package'
  }
  

 def mavenVersionUpdatePatch() {
    script.sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit'
  }

 def mavenVersionUpdateMinor() {
    script.sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.\\${parsedVersion.incrementalVersion} versions:commit'
  }

 def mavenVersionUpdateMajor() {
    script.sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.incrementalVersion} versions:commit'
  }


def mavenParseVersion() {
    def pomContent = script.readFile('pom.xml') 
    def matcher = pomContent =~ '<version>(.+)</version>'
    def extract_vers = matcher[0][1]
    script.env.VERSION = extract_vers
  }

}

