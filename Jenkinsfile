pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Your build steps go here
                    bat "mvn clean compile"
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
    }
}
