# Sample Grails 3.1.13 application for Jackson Groovy Closure error demonstration

If you define a closure in application.groovy (like grails.gorm.default.mapping), you get Jackson errors if you access the Spring Actuator endpoint /env


    grails run-app

then access http://localhost:8080/env

Configuration of this project:

 - Uses joda-time plugin
 - Defines the Joda Time user-type registrations in application.groovy
 - Eenabled endpoints in application.yml
 - No other changes.


What has been tried so far to workaround this issue:

 - Add a BeanInitializer Component to:
  1. Register an ErrorSerializer for GroovyClassLoader: Does not work, as the suspect type is GroovyClassLoader$1
  2. Set Visibility ANY (as stated by baeldung): Does not help
  3. Set objectMapper configuration SerializationFeature.FAIL_ON_EMPTY_BEANS to false: Does not help.
