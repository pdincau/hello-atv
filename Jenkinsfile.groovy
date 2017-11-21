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
        sh "kubectl create -f deployment.yml"
    }

}