node {

    def mavenHome = tool 'Maven'
    def app

    stage("Checkout and test") {
        checkout scm
        sh "${mavenHome}/bin/mvn clean test"
    }

    stage("Build") {
        sh "${mavenHome}/bin/mvn package"
        app = docker.build("pdincau/hello-ivo")
    }

    stage("Push image") {
        app.push("${env.BUILD_NUMBER}")
        app.push("latest")
    }

    stage("Deploy new version") {
        sh "kubectl set image deployment/hello-java-deployment hello-java=pdincau/hello-ivo:${env.BUILD_NUMBER}"
    }
}