#!/usr/bin/env groovy

import com.example.Git

def call(String git_credentials, String repoUrl) {
  return new Git(this).gitSetRepository(git_credentials, repoUrl)
}

