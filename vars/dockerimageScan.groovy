def call(String project , String imageTag , String userName ) {
    sh '''
        trivy image ${project}:v1.${imageTag} ${userName}/${project}:latest > scan.txt
        echo "Showing scan file"
        cat scan.txt
    '''
}