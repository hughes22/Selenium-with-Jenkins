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
                post {
                    // If Maven was able to run the tests, even if some of the test
                    // failed, record the test results and archive the jar file.
                    success {
                        publishHTML([
                                allowMissing          : false,
                                alwaysLinkToLastBuild : false,
                                keepAll               : false,
                                reportDir             : 'target/surefire-reports/',
                                reportFiles           : 'emailable-report.html',
                                reportName            : 'HTML Report',
                                reportTitles          : '',
                                useWrapperFileDirectly: true])
                    }
                }
            }
        }
    }
}
