def call() {
    sh 'mvn verify -DskipUnitTest'
}