// default mappings
grails.gorm.default.mapping = {
  // UUID (String) ids
  //id(generator:"com.symentis.les.hibernate.UUIDCustomIdGenerator", type:"string", length:36) // globally use UUID as id generator
  //
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentDateMidnight, class:org.joda.time.DateMidnight
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentDateTime, class:org.joda.time.DateTime
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentDateTimeZoneAsString, class:org.joda.time.DateTimeZone
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentDurationAsString, class:org.joda.time.Duration
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentInstantAsMillisLong, class:org.joda.time.Instant
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentInterval, class:org.joda.time.Interval
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentLocalDate, class:org.joda.time.LocalDate
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime, class:org.joda.time.LocalDateTime
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentLocalTime, class:org.joda.time.LocalTime
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentPeriodAsString, class:org.joda.time.Period
  "user-type" type:org.jadira.usertype.dateandtime.joda.PersistentYears, class:org.joda.time.Years
}

