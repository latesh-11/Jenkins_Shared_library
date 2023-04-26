def call( String project , String imageTag , String userName ){
    withCredentials([string(credentialsId: 'docker-pass', variable: 'docker-psaswd')]) {
        sh'''
            docker imaeg push -u ${userName}/${project}:v1.${imageTag}
            docker imaeg push -u ${userName}/${project}:latest
        '''
    }
}