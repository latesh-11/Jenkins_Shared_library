def call( String project , String imageTag , String userName ){
    withCredentials([string(credentialsId: 'docker-key', variable: 'passwd')]) {
        sh'''
            docker login -u ${userName} -p ${passwd}
            docker image push ${userName}/${project}:v1.${imageTag}
            docker image push ${userName}/${project}:latest


            sh 'docker image rm -f ${project}:v1.${imageTag} ${userName}/${project}:v1.${imageTag} docker image push ${userName}/${project}:latest'
        '''
    }
}