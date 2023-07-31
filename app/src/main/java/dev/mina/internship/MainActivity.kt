package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {

                ProfileCard()

                val state = rememberScrollState()
                Column(modifier = Modifier.verticalScroll(state),) {

                }
            }

            // show list of 20 items
        }
    }
}


data class Profile (val name:String,val job :String)


fun getDummyProfiles(): List<Profile> {
    return listOf(
        Profile("John", "Software Engineer"),
        Profile("Alice", "Designer"),
        Profile("Bob", "Data Scientist"),
        Profile("Emily", "Product Manager"),
        Profile("Michael", "Marketing Specialist"),
        Profile("Olivia", "Teacher"),
        Profile("David", "Doctor"),
        Profile("Sophia", "Accountant"),
        Profile("Daniel", "Sales Manager"),
        Profile("Emma", "HR Manager"),
        Profile("William", "Graphic Designer"),
        Profile("Ava", "Lawyer"),
        Profile("James", "Chef"),
        Profile("Isabella", "Architect"),
        Profile("Alexander", "Financial Analyst"),
        Profile("Mia", "Journalist"),
        Profile("Ethan", "Mechanical Engineer"),
        Profile("Charlotte", "Nurse"),
        Profile("Oliver", "Photographer"),
        Profile("Amelia", "Researcher")
    )
}
@Composable
fun ProfileCard() {
    Card(
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Avatar Image
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name and Description
            Text(
                text = "John Doe",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Software Engineer",
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}