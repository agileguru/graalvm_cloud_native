
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
                    sh 'mvn -f ./graalvmcloudnativeserver/pom.xml clean install'
                }
            }
        }

        stage('Build Client') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh 'mvn -f ./graalvmcloudnativeclient/pom.xml clean install'
                }
            }
        }
    }
  }
}