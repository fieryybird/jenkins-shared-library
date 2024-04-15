#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
        withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh 'docker build -t 37.187.124.95:8888/demojavapp:v2.0 .'
            sh "echo $PASS | docker login 37.187.124.95:8888 -u $USER --password-stdin"
            sh 'docker push 37.187.124.95:8888/demojavapp:v2.0'
    }
}