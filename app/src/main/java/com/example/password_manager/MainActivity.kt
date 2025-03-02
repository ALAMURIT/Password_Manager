package com.example.password_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.password_manager.ui.theme.Password_ManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Password_ManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ManagerHomeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun ManagerHomeScreen(){
    var _passwordGeneratorObject = PasswordGenerator()
    var _generatedPassword=""
    //fields
        //url
        //username
        //password
    //buttons
        //register
        //view
        //clear
    Column {
        //var _urlText = UrlField()
        //var _userNameText = UserNameField()
        var _passwordStrengthText = StrengthField().toInt()
        Button(onClick = {_generatedPassword=_passwordGeneratorObject.GeneratePassword(_passwordStrengthText)}) {
            Text(text = "Generate password")
        }
        Text(text = "Password is:\n$_generatedPassword")
    }
}

//url field
@Composable
fun UrlField(): String{
    var _url by remember { mutableStateOf("") }
    TextField(
        value = _url,
        onValueChange = {_url=it},
        label = { Text("url") }
    )
    return _url
}
//url field
@Composable
fun UserNameField(): String{
    var _userName by remember { mutableStateOf("") }
    TextField(
        value = _userName,
        onValueChange = {_userName=it},
        label = { Text("User Name") }
    )
    return _userName
}
//url field
@Composable
fun StrengthField(): Int{
    var _passwordStrength by remember { mutableStateOf("8") }
    TextField(
        value = _passwordStrength,
        onValueChange = {_passwordStrength=it},
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return _passwordStrength.toInt()
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Password_ManagerTheme {
//        Greeting("Android")
//    }
//}
@Preview
@Composable
fun PasswordManagerPreview(){
    ManagerHomeScreen()
}