
pipeline {
  agent {
    kubernetes {
        // label 'docker-build-pod'
        yamlFile 'podtemplate/jenkinstemplate.yaml'
        idleMinutes 120
    }
  }
  stages {
        stage('Get Config Settings') {
            steps {
                container('google') {
                    // Build your Java application
                    sh 'gsutil cp gs://devops-353009-configurations/maven/settings.xml ~/.m2/settings.xml'
                }
            }
        }

        stage('Build Server') {
            steps {
                container('maven') {
                    // Build your Java application
                    sh 'cat ~/.m2/settings.xml'
                    sh 'mvn -f ./graalvmcloudnativeserver/pom.xml clean install'
                }
            }
        }

        // stage('Build Client') {
        //     steps {
        //         container('maven') {
        //             // Build your Java application
        //             sh 'mvn -f ./graalvmcloudnativeclient/pom.xml clean install'
        //         }
        //     }
        // }
        stage('Docker Build') {
        steps {
            container('docker'){
            sh 'docker images'
            }
        }
    }
    
  }
}