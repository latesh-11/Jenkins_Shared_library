// def call( String project , String imageTag , String userName ){
//     withCredentials([string(credentialsId: 'docker-key', variable: 'passwd')]) {
//         sh'''
//             docker login -u ${userName} -p ${passwd}
//             docker image push ${userName}/${project}:${imageTag}
//             docker image push ${userName}/${project}:latest

//             docker image rm -f ${userName}/${project}:${imageTag}
//             docker image rm -f ${userName}/${project}:latest

//         '''
//     }
// }

def call( String region , String accountID , String userName ) {
    withAWS(credentials: 'AWS_creds', region: 'us-east-1'){
        sh """
            aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${accountID}.dkr.ecr.${region}.amazonaws.com
            docker push ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest
        
            docker rm image -f ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest
        """
    }    
   
}