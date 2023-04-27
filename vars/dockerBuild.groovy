// def call(String project , String imageTag , String userName) {
//       sh '''
//         docker image build -t ${project}:v1.${imageTag} .
//         docker image tag ${project}:${imageTag} ${userName}/${project}:v1.${imageTag}
//         docker image tag ${project}:${imageTag} ${userName}/${project}:latest
//         '''
// }

def call( String userName , String accountID ,  String region ) {
  
    sh """
      docker build -t ${userName} .
      docker tag ${userName}:latest ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest
    """
  
}