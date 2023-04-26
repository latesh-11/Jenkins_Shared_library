def call(String project , String imageTag , String userName ) {
    sh '''
        trivy image ${userName}/${project}:latest > scan.txt
        echo "Showing scan file"
        cat scan.txt
    '''
}