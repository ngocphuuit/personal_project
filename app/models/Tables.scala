package models

import org.joda.time._
import slick.lifted.Tag
import models.CommonConvert._
import slick.driver.MySQLDriver.api._
/**
  * Created by phunn on 1/11/16.
  */
class UserTable(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def email = column[String]("email")
  def password = column[String]("password")
  def userRole = column[String]("user_role")
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def profilePhoto = column[String]("profile_photo")
  def facebookId = column[String]("facebook_id")
  def lastCaptureTime = column[DateTime]("last_capture_time")
  def status = column[Int]("status")
  def createdTime = column[DateTime]("created_time")
  def updatedTime = column[DateTime]("updated_time")

  def * = (id.?, email, password, userRole, firstName.?, lastName.?, profilePhoto.?, facebookId, lastCaptureTime.?, status, createdTime, updatedTime) <> (User.tupled, User.unapply)

}