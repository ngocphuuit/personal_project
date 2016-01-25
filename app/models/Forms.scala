package models


case class FormCreateUser(
  first_name: String,
  last_name: String,
  username: String,
  email: String,
  password: String
)

case class FormLogin(
  username: String,
  password: String
)
