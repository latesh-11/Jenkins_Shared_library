def call() {
    waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api-key'
}