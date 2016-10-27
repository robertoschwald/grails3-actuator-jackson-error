# Sample Grails 3.1.13 application for Jackson Groovy Closure error demonstration

If you define a closure in application.groovy (like grails.gorm.default.mapping), you get Jackson errors if you access the Spring Actuator endpoint /env


    grails run-app

then access http://localhost:8080/env

Configuration of this project:

 - Uses joda-time plugin
 - Defines the Joda Time user-type registrations in application.groovy
 - Enabled actuator endpoints in application.yml
 - No other changes.


What has been tried so far to workaround this issue:

 - Add a BeanInitializer Component to:
  1. Register an ErrorSerializer for GroovyClassLoader: Does not work, as the suspect type is GroovyClassLoader$1
  2. Set Visibility ANY (as stated by baeldung): Does not help
  3. Set objectMapper configuration SerializationFeature.FAIL_ON_EMPTY_BEANS to false: Does not help.
  
  
  
## Exception thrown

```
Caused by: com.fasterxml.jackson.databind.JsonMappingException: No serializer found for class groovy.lang.GroovyClassLoader$1 and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) ) (through reference chain: java.util.LinkedHashMap["applicationConfig: [classpath:/application.groovy]"]->java.util.LinkedHashMap["grails.gorm.default.mapping"]->_run_closure1["delegate"]->script14775830011902070609279["binding"]->groovy.util.ConfigBinding["callable"]->groovy.util._parse_closure6["delegate"]->groovy.util.ConfigSlurper["classLoader"]->groovy.lang.GroovyClassLoader["resourceLoader"])
	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.failForEmpty(UnknownSerializer.java:69)
	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.serialize(UnknownSerializer.java:32)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:693)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:675)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:157)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFields(MapSerializer.java:561)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:469)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:29)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFields(MapSerializer.java:561)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:469)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:29)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:130)
	at com.fasterxml.jackson.databind.ObjectWriter$Prefetch.serialize(ObjectWriter.java:1387)
	at com.fasterxml.jackson.databind.ObjectWriter.writeValue(ObjectWriter.java:889)
	at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:269)
```
