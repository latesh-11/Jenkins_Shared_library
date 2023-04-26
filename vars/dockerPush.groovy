def call( String project , String imageTag , String userName ){
    withCredentials([string(credentialsId: 'docker-pass', variable: 'docker-psaswd')]) {
        sh'''
            docker login -u ${userName} -p ${docker-passwd}
            docker imaeg push ${userName}/${project}:v1.${imageTag}
            docker imaeg push ${userName}/${project}:latest
        '''
    }
}