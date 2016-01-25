package models

import slick.driver.MySQLDriver.api._

/**
  * Created by phunn on 1/11/16.
  */
object CommonConvert {
  implicit val dateTimeColumnType = MappedColumnType.base[org.joda.time.DateTime, java.sql.Timestamp](
    { dt => new java.sql.Timestamp(dt.getMillis) },
    { ts => new org.joda.time.DateTime(ts)}
  )
}
