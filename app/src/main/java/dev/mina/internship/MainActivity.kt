package dev.mina.internship

import android.app.NotificationChannel
import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var id by remember { mutableStateOf(0) }
            BMInternshipTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    val context = LocalContext.current
                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123123123"))
                        context.startActivity(Intent.createChooser(intent, "Start dialing with.,."))
                    }) {
                        Text(text = "Dial")
                    }
                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_TEXT, "asda asdasd awsdasd")
                        context.startActivity(Intent.createChooser(intent, "Start Sending with.,."))
                    }) {
                        Text(text = "Send")
                    }
                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_TEXT, "asda asdasd awsdasd")
                        context.startActivity(Intent.createChooser(intent, "Start Sending with.,."))
                    }) {
                        Text(text = "Send")
                    }
                    Button(onClick = {
                        val intent = Intent("dev.mina.internship.MY_ACTION")
                        intent.putExtra("My_Extra", "asda asdasd awsdasd")
                        context.startActivity(Intent.createChooser(intent, "Start Sending with.,."))
                    }) {
                        Text(text = "Custom Action")
                    }
                    Button(onClick = {
                        id++
                        showNotification(id)
                    }) {
                        Text(text = "Show Notification")
                    }
                }
            }
        }
    }

    private fun showNotification(id: Int) {

        val channelID = "Channel1"
        val channelName = "Incoming Mail"

        val channel =
            NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val notificationBuilder =
            NotificationCompat.Builder(this, channelID)
                .setContentTitle("New Title")
                .setContentText("asdasd asd asd asd")
                .setSmallIcon(android.R.drawable.alert_dark_frame)

        notificationManager.notify(id, notificationBuilder.build())


    }

    val receiver = MyReceiver()
    override fun onResume() {
        super.onResume()
        val interFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(receiver, interFilter)
    }

}
