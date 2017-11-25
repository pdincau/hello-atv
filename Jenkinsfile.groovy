node {

    def mvnHome = tool "Maven"
    def app

    stage("Checkout and Test") {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }

    stage("Build") {
        sh "${mvnHome}/bin/mvn package"
        app = docker.build("pdincau/hello-atv")
    }

    stage("Push Image") {
        app.push("${env.BUILD_NUMBER}")
    }
}