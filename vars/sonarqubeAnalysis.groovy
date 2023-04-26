def call(){
    withSonarQubeEnv(credentialsId: 'sonar-api-key'){
    sh 'mvn clean package sonar:sonar'
    }
}