#!/usr/bin/env groovy

import com.example.Git

def call(String repoUrl) {
  return new Git(this).gitCommitVersionUpdate(appVersion)
}

