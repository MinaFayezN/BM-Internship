package dev.mina.internship.ui.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mina.internship.R

@Preview(showBackground = true)
@Composable
fun ListScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        repeat(10) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User Profile"
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Contact Name ${it + 1}",
                        style = TextStyle(color = Color.DarkGray, fontSize = 24.sp)
                    )
                    Text(
                        text = "email: user_${it + 1}@mail.com",
                        style = TextStyle(color = Color.White, fontSize = 12.sp)
                    )
                }
                //email
            }
        }

    }
}

@Composable
private fun ProfileImage(user: Int) {
    Image(
        modifier = Modifier
            .padding(2.dp)
            .size(48.dp),
        painter = painterResource(id = user),
        contentDescription = "User Profile"
    )
}

@Composable
private fun RowExample() {
    Row(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Row content 01",
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 4.dp)
        )
        Text(text = "Row content 02", modifier = Modifier.align(Alignment.Top))
        Text(text = "Row content 03")
    }
}

@Composable
private fun ColumnExample() {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
//        repeat(5) {
//            Text(text = "Column content $it")
//        }
        Text(text = "Column content 01", modifier = Modifier.align(Alignment.End))
        Text(text = "Column content 02")
        Text(text = "Column content 03")
        Text(text = "Column content 04")
        Text(text = "Column content 05", modifier = Modifier.align(Alignment.End))
        Text(text = "Column content 06")
        Box(/*modifier = Modifier.weight(1F)*/) {
            Text(text = "Column content 07", modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}