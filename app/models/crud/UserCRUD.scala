package models.crud

import models._
import play.api.Play
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import play.api.db.slick.HasDatabaseConfig
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

/**
  * Created by phunn on 1/11/16.
  */

class UserCRUD extends HasDatabaseConfig[JdbcProfile]{
  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  private val users = TableQuery[UserTable]

  def store(user: User): Future[Unit] = db.run(users += user).map(_ => ())

  def getAll(): Future[List[User]] = db.run(users.result).map(_.toList)

  def getByEmail(email: String): Future[Option[User]] = db.run(users.filter(_.email === email).result.headOption)

  def getByUsernm

}