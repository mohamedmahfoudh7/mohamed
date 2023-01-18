agent any
     environment {
        DOCKERHUB_CREDENTIALS = credentials('devDH')
    }
            

        stages{

                stage('Docker login') {
                             steps {
                                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                               }  }

			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t mohamed/projectdevops .'
                                 }
                             }
                         }

                               
                               
		        stage('Docker push') {
                             steps {
                                    sh 'echo "Docker is pushing ...."'
                     	            sh 'docker push mohamed/projectdevops'
                               }  }

                stage('Docker compose') {
                             steps {
                                    sh 'docker-compose up -d'
                                   }  }


        
}
}
