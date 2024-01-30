pipeline {
    agent {
        kubernetes {
            // Configure the Kubernetes Pod template for Java 21 and Docker support
            yaml '''
                apiVersion: v1
                kind: Pod
                spec:
                  containers:
                    - name: maven
                      image: maven:3.9.4-amazoncorretto-21
                      command:
                      - cat
                      tty: true
            '''
        }
    }

                //     volumeMounts:
                //     - name: docker-sock
                //       mountPath: /var/run/docker.sock
                //   volumes:
                //   - name: docker-sock
                //     hostPath:
                //       path: /var/run/docker.sock
    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your repository
                git branch: 'main', url: 'https://github.com/agileguru/graalvm_cloud_native.git'
            }
        }

        stage('Build Server') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh 'cd graalvmcloudnativeserver'
                    sh './mvnw clean install'
                }
            }
        }

        stage('Build Client') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh 'cd graalvmcloudnativeclient'
                    sh './mvnw clean install'
                }
            }
        }

        // stage('Push Docker Image') {
        //     steps {
        //         // Build the Docker image using a Dockerfile
        //         sh 'docker push us-central1-docker.pkg.dev/devops-353009/devops-docker/graalvmcloudnativeserver:main'
        //         sh 'docker push us-central1-docker.pkg.dev/devops-353009/devops-docker/graalvmcloudnativeclient:main'
        //     }
        // }

    }
}
