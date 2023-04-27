// def call(String project , String imageTag , String userName) {
//       sh '''
//         docker image build -t ${project}:v1.${imageTag} .
//         docker image tag ${project}:${imageTag} ${userName}/${project}:v1.${imageTag}
//         docker image tag ${project}:${imageTag} ${userName}/${project}:latest
//         '''
// }

def call(String region , String accountID , String userName) {
  withCredentials([<object of type com.cloudbees.jenkins.plugins.awscredentials.AmazonWebServicesCredentialsBinding>]) {
    sh """
      docker build -t ${userName} .
      docker tag ${userName}:latest ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest

    """
  }
}