#!/usr/bin/env groovy

import com.example.Git

def call(String version) {
  return new Git(this).gitCommitVersionUpdate(version)
}

