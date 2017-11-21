node {

    def mvnHome = tool 'Maven'
    def app

    stage("Checkout and test") {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }

    stage("Build") {
        sh "${mvnHome}/bin/mvn -DskipTests package"
        app = docker.build("pdincau/hello-atv")
    }

    stage("Push artifact") {
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
    }

    stage("Deploy") {
        sh "kubectl set image deployment/hello-atv-deployment hello-atv=pdincau/hello-atv:${env.BUILD_NUMBER}"
    }

}