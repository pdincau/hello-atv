node {

    def mvnHome = tool "Maven"
    
    stage("Checkout and Test") {
        sh "${mvnHome}/bin/mvn clean test"
    }
}