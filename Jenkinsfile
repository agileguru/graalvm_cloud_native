
pipeline {
  agent {
    kubernetes {
        // label 'docker-build-pod'
        yamlFile 'podtemplate/jenkinstemplate.yaml'
        idleMinutes 120
    }
  }
  stages {
        stage('Get Build Config') {
            steps {
                container('google') {
                    // Build your Java application
                    sh 'gsutil cp gs://devops-353009-configurations/maven/settings.xml .'
                }
            }
        }
        stage('Build Server') {
            steps {
                container('google') {
                    // Build your Java application
                    sh './graalvmcloudnativeserver/mvnw --settings ./settings.xml -f ./graalvmcloudnativeserver/pom.xml clean install'
                }
            }
        }

        stage('Build Client') {
            steps {
                container('google') {
                    // Build your Java application
                    sh 'mvn --settings ./settings.xml -f ./graalvmcloudnativeclient/pom.xml clean compile'
                }
            }
        }
        stage('Docker Build') {
            steps {
                container('google'){
                    sh 'docker images'
                }
            }
        }
    }
}