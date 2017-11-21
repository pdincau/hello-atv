node {

    def mvnHome = tool 'Maven'
    def app

    stage("Checkout and test") {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }

}