node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Get some code from a GitHub repository
   git url: 'https://github.com/peepa/java-maven-docker'

   // Get the maven tool.
   // ** NOTE: This 'M3' maven tool must be configured
   // **       in the global configuration.
   def mvnHome = tool 'M3'

   // Mark the code build 'stage'....
   stage 'Build'
   // Run the maven build
   sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"

   //run in parallel
   parallel firstBranch: {
           // do something
           sh "echo \"long nap\"; sleep 60; echo \"long nap is over\""
       }, secondBranch: {
           // do something else
           sh "echo \"short nap\"; sleep 5; echo \"short nap is over\""
       },
       failFast: true

   step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

   // not yet compatible with pipeline :(
   //step([$class: 'JaCoCoPublisher', execPattern: '**/target/unit-tests/coverage-reports/*.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java' ])



   stage 'Build docker container'
   sh "docker build --no-cache --rm -t peepa/java-hello-world ."

   stage 'Manual tests'
   input message: 'Manual Tests', ok: 'Passed', parameters: [string(defaultValue: '', description: '', name: 'Tester\'s name')]
}