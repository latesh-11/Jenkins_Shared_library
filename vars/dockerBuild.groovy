def call(String project , String imageTag , Stirng userName) {
      sh '''
        docker image build -t ${project}:v1.${imageTag} .
        docker image tag ${project}:v1.${imageTag} ${userName}/${project}:v1.${imageTag}
        docker image tag ${project}:v1.${imageTag} ${userName}/${project}:latest
        '''
}