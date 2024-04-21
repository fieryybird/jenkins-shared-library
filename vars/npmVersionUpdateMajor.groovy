#!/usr/bin/env groovy

import com.example.Npm

def call() {
  return new Npm(this).npmVersionUpdateMajor()
}