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
   step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
   step([$class: 'JaCoCoPublisher', execPattern: '**/target/unit-tests/coverage-reports/*.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java' ])


   stage 'Manual tests'
   input message: 'Manual Tests', ok: 'Passed', parameters: [string(defaultValue: '', description: '', name: 'Tester\'s name')]
}