node {

    def mavenHome = tool 'Maven'

    stage("Checkout and test") {
        checkout scm
        sh "${mavenHome}/bin/mvn clean test"
    }
}