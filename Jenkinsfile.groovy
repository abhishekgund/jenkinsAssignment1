pipeline {
    agent any
    stages {
        stage('Checkout Develop Branch') {
            steps {
                // Task 2: Force checkout into 'my-project-folder'
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/develop']], 
                    extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'my-project-folder']], 
                    userRemoteConfigs: [[url: 'YOUR_GIT_REPO_URL', credentialsId: 'YOUR_CRED_ID']]
                ])
            }
        }
        stage('Verify Files') {
            steps {
                // This step MUST appear in your console logs
                echo "Checking contents of my-project-folder..."
                sh 'ls -la my-project-folder' 
            }
        }
    }
}
