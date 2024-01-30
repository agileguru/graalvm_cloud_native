
pipeline {
  agent {
    kubernetes {
        // label 'docker-build-pod'
        yamlFile 'podtemplate/jenkinstemplate.yaml'
        idleMinutes 120
    }
  }
  stages {
        stage('Build Server') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh './graalvmcloudnativeserver/mvnw -f ./graalvmcloudnativeserver clean install'
                }
            }
        }

        stage('Build Client') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh './graalvmcloudnativeclient/mvnw -f ./graalvmcloudnativeclient clean install'
                }
            }
        }
        stage('Docker Build') {
        steps {
            container('docker'){
            sh 'docker images'
            }
        }
    }
    
  }
}