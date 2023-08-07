package dev.mina.internship.ui.screens

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Parcelable
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import dev.mina.internship.SignupActivity
import kotlinx.parcelize.Parcelize

@Composable
fun MainScreen(onLoginClick: (profile: Profile) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                onLoginClick.invoke(
                    Profile(
                        name = "Amelia Jensen",
                        pass = "mattis",
                        mail = "ferri@mail.com"
                    )
                )
            }) {
            Text(text = "Open Login Activity")
        }
        StartForResultDemo()
        ImplicitIntentViewDemo()
        ImplicitIntentDialDemo()
    }
}

@Composable
private fun StartForResultDemo() {
    var resultText by remember { mutableStateOf("") }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
//                result.data
                resultText = result.data?.getStringExtra("data") ?: "No data"

            }
        }
    )
    val context = LocalContext.current
    Button(
        onClick = {
            // launch signup activity and get result
            // Bottom sheet
            launcher.launch(Intent(context, SignupActivity::class.java))
        }) {
        Text(text = "Open Signup Activity and get result")
    }
    Text(
        text = resultText,
    )
}


@Composable
fun ImplicitIntentViewDemo() {
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
    Button(onClick = {
        context.startActivity(Intent.createChooser(intent, "Please select app to handle"))

    }) {
        Text(text = "Start view url")
    }
}

@Composable
fun ImplicitIntentPickDemo() {
    val context = LocalContext.current
    var imageList by remember { mutableStateOf(listOf<Uri>()) }
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { result: List<Uri> ->

        }
    )

    Button(onClick = {
        context.startActivity(Intent.createChooser(intent, "Please select app to handle"))

    }) {
        Text(text = "Start Image Pick")
    }


}

@Composable
fun ImplicitIntentDialDemo() {
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:123123123"))

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {

            } else {

            }
        }
    )


    Button(onClick = {
        val permission = Manifest.permission.CALL_PHONE
        var isPermissionGranted = ActivityCompat.checkSelfPermission(context, permission)
        if (isPermissionGranted == PackageManager.PERMISSION_GRANTED)
            context.startActivity(intent)
        else {
            launcher.launch(permission)
        }

    }) {
        Text(text = "Start dial")
    }
}

@Parcelize
data class Profile(
    val name: String,
    val pass: String,
    val mail: String,
//    val addressList: Array<Address>,
) : Parcelable

@Parcelize
data class Address(
    val street: String,
    val area: String,
) : Parcelable