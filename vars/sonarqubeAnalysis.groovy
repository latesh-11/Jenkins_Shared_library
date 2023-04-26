def call(){
    waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api-key'
    sh 'mvn clean package sonar:sonar'
}