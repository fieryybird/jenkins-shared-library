#!/usr/bin/env groovy

import com.example.Git

def call() {
  return new Git(this).gitConfigJenkinsUser()
}

