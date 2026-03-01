pipeline {
    agent any

    environment {
        DOCKER_USER = 'deadmonk'
        IMAGE_NAME = "${DOCKER_USER}/minicalculator"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Package Application') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${env.BUILD_NUMBER} ."
                sh "docker tag ${IMAGE_NAME}:${env.BUILD_NUMBER} ${IMAGE_NAME}:latest"
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER_CRED')]) {

                    sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER_CRED --password-stdin"
                    sh "docker push ${IMAGE_NAME}:${env.BUILD_NUMBER}"
                    sh "docker push ${IMAGE_NAME}:latest"
                }
            }
        }

        stage('Deploy') {
                    steps {
                        sh "ansible-playbook -i inventory.ini deploy.yml --extra-vars 'docker_user=${DOCKER_USER}'"
                    }
                }
    }
    post {
            success {
                mail to: 'ranjan.abhishek8809@gmail.com',
                     subject: "SUCCESS: MiniCalculator Build #${env.BUILD_NUMBER}",
                     body: "Maalik, pipeline kaam kr rha hai! The new features are tested, built, and deployed.\n\nCheck the build here: ${env.BUILD_URL}"
            }
            failure {
                mail to: 'ranjan.abhishek8809@gmail.com',
                     subject: "FAILED: MiniCalculator Build #${env.BUILD_NUMBER}",
                     body: "Are maalik wo thoda sa galti ho gyi. Please check the logs.\n\nCheck the build here: ${env.BUILD_URL}"
            }
        }
}