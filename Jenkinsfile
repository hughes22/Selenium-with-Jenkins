pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Your build steps go here
                    echo 'Building...'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Your test steps go here
                    bat "mvn verify"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Your deploy steps go here
                    echo 'echo Deploying...'
                }
            }
        }
    }
}
