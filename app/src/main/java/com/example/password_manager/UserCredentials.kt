package com.example.password_manager

class UserCredentials(
    val _siteAddress: String,
    var _userName: String,
    var _password: String,
    val _dateCreated: String,
) {
    val _url=_siteAddress
    var _userNameValue=_userName
    var _passwordValue=_password
    val _timeStamp=_dateCreated
}