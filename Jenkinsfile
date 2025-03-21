pipeline {
    agent any

    environment {
        WORKSPACE_DIR = 'D:/Apps/Java/Learning-microservices/hello-db-service'
        IMAGE_NAME = 'hellodbservice'
        CONTAINER_NAME = 'cool_kowalevski'
    }

    stages {
        
        stage('Build with Maven') {
            steps {
                bat "cd /d %WORKSPACE_DIR% && mvn clean package -DskipTests"
            }
        }
        
        stage('Build Docker Image') {
            steps {
                bat "cd /d %WORKSPACE_DIR% && docker build -t %IMAGE_NAME% ."
            }
        }

        stage('Run Docker Container') {
            steps {
                bat "docker stop %CONTAINER_NAME% || exit 0"
                bat "docker rm %CONTAINER_NAME% || exit 0"
                bat "cd /d %WORKSPACE_DIR% && docker run -d --name %CONTAINER_NAME% -p 8088:8088 %IMAGE_NAME%"
            }
        }

        stage('Post Build Actions') {
            steps {
                echo 'Build and Deployment Successful!'
            }
        }
    }
}
