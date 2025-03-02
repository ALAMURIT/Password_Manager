package com.example.password_manager

import kotlin.random.Random

class PasswordGenerator {
    val _capitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val _smallLetters="abcdefghijklmnopqrstuvwxyz"
    val _numberLetters="0123456789"
    val _specialLetters="!@#$%^&*"
    fun _smallLetterGenerator(): String {
        return _smallLetters[Random.nextInt(_smallLetters.length)].toString()
    }
    fun _capitalLetterGenerator(): String {
        return _capitalLetters[Random.nextInt(_capitalLetters.length)].toString()
    }
    fun _numberLetterGenerator(): String {
        return _numberLetters[Random.nextInt(_numberLetters.length)].toString()
    }
    fun _speciaLetterGenerator(): String {
        return _specialLetters[Random.nextInt(_specialLetters.length)].toString()
    }
    fun GeneratePassword(_passwordStrength: Int): String{
        var _password=""
        for (i in 0.._passwordStrength){
            var _index=Random.nextInt(3);
            when(_index){
                0->{
                    _password+=_capitalLetterGenerator()
                }
                1->{
                    _password+=_smallLetterGenerator()
                }
                2->{
                    _password+=_numberLetterGenerator()
                }
                else->{
                    _password+=_speciaLetterGenerator()
                }
            }
        }
        return _password
    }
}