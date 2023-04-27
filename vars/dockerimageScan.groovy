def call(String userName , String accountID , String region ) {
    sh """
        trivy image ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest > scan.txt
        echo "Showing scan file"
        cat scan.txt
    """
}

// trivy image ${userName}/${project}:latest > scan.txt