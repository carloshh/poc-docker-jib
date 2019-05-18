pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                    git(url: 'https://github.com/carloshh/docker-jib.git', branch: "jenkins")
            }
        }

        stage('unit tests') {
            steps {
                sh './mvnw test'
            }
        }

        stage('coverage') {
            steps {
                sh './mvnw org.jacoco:jacoco-maven-plugin:0.8.4:prepare-agent install -Dmaven.test.failure.ignore=false'
            }
        }

        stage('build') {
            steps {
                sh './mvnw package'
            }
        }

        stage('Sonarqube') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }

            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

    }
}