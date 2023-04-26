def call( String project , String imageTag , String userName ){
    withCredentials([string(credentialsId: 'docker-key', variable: 'passwd')]) {
        sh'''
            docker login -u ${userName} -p ${passwd}
            docker image push ${userName}/${project}:v1.${imageTag}
            docker image push ${userName}/${project}:latest

            docker image rm -f ${userName}/${project}:v1.${imageTag}
            dockr image rm -f {userName}/${project}:latest

        '''
    }
}