pipeline {
    environment {
        registryCredential = "docker"
    }
    tools {
        maven 'maven'
    }
    agent any
    stages {
        stage(’Initialize’){
            def dockerHome = tool 'myDocker'
            env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage(‘Build’) {
            steps{
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage(‘Load’) {
            steps{
               script {
                  app = docker.build("althalvey/backend-service")
                }
             }
        }
//         stage(‘Deploy’) {
//             steps{
//                 script {
//                     docker.withRegistry( "https://registry.hub.docker.com", registryCredential ) {
//                         // dockerImage.push()
//                         app.push("latest")
//                     }
//                 }
//             }
//         }
        stage('Deploy to k8s'){
            steps{
                sh 'kubectl apply -f sample.yaml'
            }
        }
    }
}