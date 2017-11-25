node {

    def mvnHome = tool "Maven"

    stage("Checkout and Test") {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }
}