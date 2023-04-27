def call(String region , String accountID , String userName) {
    sh """
        trivy image ${userName}:latest ${accountID}.dkr.ecr.${region}.amazonaws.com/${userName}:latest > scan.txt
        echo "Showing scan file"
        cat scan.txt
    """
}

// trivy image ${userName}/${project}:latest > scan.txt