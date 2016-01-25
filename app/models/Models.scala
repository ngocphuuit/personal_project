package models

import org.joda.time.DateTime
/**
  * Created by phunn on 1/11/16.
  */
case class User(
   id: Option[Int],
   email: String,
   password: String,
   userRole: String,
   firstName: Option[String],
   lastName: Option[String],
   profilePhoto: Option[String],
   facebookId: String,
   lastCaptureTime: Option[DateTime],
   status: Int,
   createdTime: DateTime,
   updatedTime: DateTime

)
