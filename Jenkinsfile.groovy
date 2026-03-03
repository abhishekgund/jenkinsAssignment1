pipeline {
    agent any
    
    stages {
        stage('Pull Develop Content') {
            steps {
                // Task 2: Pull 'develop' branch content into 'my-project-folder'
                dir('my-project-folder') {
                    checkout scm
                }
            }
        }
        
        stage('Verify Pull') {
            steps {
                // Verify the folder was created and contains files
                sh 'ls -R my-project-folder'
            }
        }
    }
}
