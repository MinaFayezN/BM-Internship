package dev.mina.internship

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun MainHeaderComponent() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2F)
    ) {
        val (box, row) = createRefs()

        Box(modifier = Modifier
            .background(color = Color.Gray)
            .constrainAs(box) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            // image -> center
            // side title -> top start
            // main title (column contains 2 text) -> center
        }

        Row(modifier = Modifier
            .height(50.dp)
            .background(
                color = Color.DarkGray,
                shape = RoundedCornerShape(12.dp)
            )
            .constrainAs(box) {
                top.linkTo(box.bottom)
                bottom.linkTo(box.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            // two tabs
        }


    }
}