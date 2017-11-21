node {

    def mvnHome = tool 'Maven'
    def app

    stage("Checkout and test") {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }

    stage("Build") {
        sh "${mvnHome}/bin/mvn -DskipTest package"
        docker.build("pdincau/hello-atv")
    }

    stage("Push artifact") {
        docker.withRegistry('https://registry.hub.docker.com', 'pdincau-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }

}