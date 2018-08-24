pipeline {
    agent any 
    stages {
        stage('clone repo and clean it') { 
            steps {
                sh "rm -rf restCountriesJenkins_qaa"
                sh "git clone https://github.com/arnaudcedric/restCountriesJenkins_qaa.git"
                sh "mvn clean -f restCountriesJenkins_qaa"
            }
        }
        stage('Test') { 
            steps {
                sh "mvn test -f restCountriesJenkins_qaa" 
            }
        }
        stage('Deploy') { 
            steps {
                sh "mvn package -f restCountriesJenkins_qaa" 
            }
        }
    }
}