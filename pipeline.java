pipeline {
    agent any

    stages {
        stage('Source Code Compilation') {
            steps {
                echo 'Compiling the source code using Maven.'
            }
        }
        stage('Testing') {
            steps {
                echo 'Executing unit tests to verify individual components.'
                echo 'Executing integration tests to validate interaction between components.'
            }
        }
        stage('Static Code Analysis') {
            steps {
                echo 'Running SonarQube to analyze the code quality and ensure adherence to standards.'
            }
        }
        stage('Security Vulnerability Scan') {
            steps {
                echo 'Conducting a security scan to detect any vulnerabilities in the code.'
            }
        }
        stage('Deploy to QA Environment') {
            steps {
                echo 'Deploying the application to the QA environment for testing.'
            }
        }
        stage('Staging Environment Testing') {
            steps {
                echo 'Performing integration tests in the staging environment to validate the deployment.'
            }
        }
        stage('Final Deployment to Production') {
            steps {
                echo 'Deploying the application to the production environment.'
            }
        }
    }
    post {
        success {
            emailext (
                to: 'sanjanaaddankiwork@gmail.com',
                subject: 'Pipeline Status: Success',
                body: 'The pipeline completed successfully. Please find the build log attached for more details.',
                attachLog: true
            )
        }
        failure {
            emailext (
                to: 'sanjanaaddankiwork@gmail.com',
                subject: 'Pipeline Status: Failure',
                body: 'The pipeline encountered an issue. Please find the build log attached for more details.',
                attachLog: true
            )
        }
    }
}