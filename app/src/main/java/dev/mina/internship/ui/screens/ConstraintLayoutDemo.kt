package dev.mina.internship.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutDemo() {

    ConstraintLayout(Modifier.fillMaxSize()) {

//        val firstRef = createRef()
//        val secondRef = createRef()
//        val thirdRef = createRef()
//

        val (firstRef, secondRef, thirdRef) = createRefs()

        Text(text = "First title asd asd", modifier = Modifier.constrainAs(firstRef) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "Second title", modifier = Modifier
            .padding(12.dp)
            .constrainAs(secondRef) {
                top.linkTo(firstRef.bottom)
                start.linkTo(firstRef.end)
            }

        )
        Text(text = "Third title", modifier = Modifier.constrainAs(thirdRef){
            top.linkTo(parent.top)
            start.linkTo(firstRef.start)
            end.linkTo(secondRef.end)
            bottom.linkTo(firstRef.top)
        })


    }


}