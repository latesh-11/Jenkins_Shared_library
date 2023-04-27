def call( String project , String imageTag , String userName ){
    withCredentials([string(credentialsId: 'docker-key', variable: 'passwd')]) {
        sh'''
            docker login -u ${userName} -p ${passwd}
            docker image push ${userName}/${project}:${imageTag}
            docker image push ${userName}/${project}:latest

            docker image rm -f ${userName}/${project}:${imageTag}
            docker image rm -f ${userName}/${project}:latest

        '''
    }
}