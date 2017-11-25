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

    stage("UAT") {
        docker.image('pdincau/hello-atv').withRun('-p 9999:8080') { c ->
            sh 'sleep 5'
            sh 'curl -v --fail 127.0.0.1:9999/ping'
            sh 'curl -s http://127.0.0.1:9999/hello?name=Ivo | grep -a \"Hello Ivo!\"'
        }
    }

    stage("Push Image") {
        app.push("${env.BUILD_NUMBER}")
    }

    stage("Deploy") {
        sh "kubectl set image deployment/hello-atv-deployment hello-atv=pdincau/hello-atv:${env.BUILD_NUMBER}"
    }
}