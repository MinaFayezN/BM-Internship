package dev.mina.internship.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.mina.internship.R

@Composable
fun ColumnDemo() {

//    val state = rememberScrollState()
//
//    Column(modifier = Modifier.verticalScroll(state)) {
//        repeat(30) {
//            Text(text = "Text In Column")
//        }
//    }

    val names = getDummyNames()
    LazyTaskBox(names)
}

@Composable
private fun LazyColumnDemo(names: List<String>) {
    LazyColumn {

//        repeat(3) {
//            item {
//                Text(text = "Lazy Column")
//            }
//        }
//        for (name in names) {
//            item {
//                Text(text = name)
//            }
//        }
//        items(names.size) { index ->
//            Text(text = "items: ${names[index]}")
//        }
        itemsIndexed(names) { index, item ->


            if (index.rem(2) == 0)
                Text(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .padding(8.dp),
                    text = "itemsIndexed: $item with index: $index",
                    style = TextStyle(color = Color.Cyan)
                )
            else
                Text(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp),
                    text = "itemsIndexed: $item with index: $index",
                    style = TextStyle(color = Color.Black)
                )
            Divider(modifier = Modifier.height(2.dp))
        }

    }
}

@Composable
private fun LazyTask(names: List<String>) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Text(
            text = "Header", modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(24.dp)
        )
        LazyColumn(Modifier.weight(1F)) {
            itemsIndexed(names) { index, item ->

                if (item.length <= 4) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray)
                            .padding(8.dp),
                        text = item,
                        style = TextStyle(color = Color.White),
                        textAlign = TextAlign.Center
                    )
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ) {
                        repeat(2) {
                            Text(
                                modifier = Modifier.weight(1F),
                                text = item,
                                style = TextStyle(color = Color.Black),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Divider(modifier = Modifier.height(2.dp))
                }
                if (index != 0 && index % 5 == 0) { /* index % 5 == 0 */
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(12.dp)
                    ) {
                        items(10) {
                            Image(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(96.dp),
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(24.dp)
        ) {
            Text(
                text = "Footer",
            )
        }

    }
}
@Composable
private fun LazyTaskBox(names: List<String>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .align(Alignment.Center)) {
            itemsIndexed(names) { index, item ->

                if (item.length <= 4) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray)
                            .padding(8.dp),
                        text = item,
                        style = TextStyle(color = Color.White),
                        textAlign = TextAlign.Center
                    )
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ) {
                        repeat(2) {
                            Text(
                                modifier = Modifier.weight(1F),
                                text = item,
                                style = TextStyle(color = Color.Black),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Divider(modifier = Modifier.height(2.dp))
                }
                if (index != 0 && index % 5 == 0) { /* index % 5 == 0 */
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(12.dp)
                    ) {
                        items(10) {
                            Image(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(96.dp),
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
        Text(
            text = "Header", modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .background(Color.White)
                .padding(24.dp)
                .align(Alignment.TopCenter)
        )

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .background(Color.White)
                .padding(24.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Footer",
            )
        }

    }
}

private fun getDummyNames() = listOf(
    "John", "Emma", "Michael", "Olivia", "William",
    "Ava", "James", "Sophia", "Alexander", "Isabella",
    "Daniel", "Mia", "David", "Emily", "Joseph",
    "Charlotte", "Matthew", "Abigail", "Ethan", "Harper",
    "Christopher", "Amelia", "Andrew", "Evelyn", "Benjamin",
    "Elizabeth", "Joshua", "Sofia", "Jackson", "Avery",
    "Sebastian", "Ella", "Logan", "Grace", "Samuel",
    "Scarlett", "Ryan", "Chloe", "Henry", "Lily",
    "Nathan", "Eleanor", "Dylan", "Hannah", "Jacob",
    "Aria", "Lucas", "Layla", "Carter", "Victoria"
)