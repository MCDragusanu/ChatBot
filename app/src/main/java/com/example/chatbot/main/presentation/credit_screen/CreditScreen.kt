package com.example.chatbot.main.presentation.credit_screen

import android.view.Surface
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.Destination

object CreditScreen : Destination("Credit Screen") {

    @Composable
    fun Main(onNavigateBack: () -> Unit /* Un buton va apela aceasta functie cand vrea sa navigezi inapoi*/) {

        //TODO distractie placuta
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.size(12.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onNavigateBack() })
                Spacer(modifier = Modifier.fillMaxSize(0.4f))


                Text(
                    text = "This project was made by : ",
                    style = Typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp)) {

                        }
                        Text(
                            text = "Andrei Antonia Stefania",
                            style = Typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp), shape = RoundedCornerShape(4.dp)) {

                        }
                        Text(
                            text = "Emilia Wu Jinhui",
                            style = Typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp), shape = RoundedCornerShape(4.dp)) {

                        }
                        Text(
                            text = "Toia Antonia Emilia",
                            style = Typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp), shape = RoundedCornerShape(4.dp)) {

                        }
                        Text(
                            text = "Rasu Matei Theodor cu Th",
                            style = Typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp), shape = RoundedCornerShape(4.dp)) {

                        }
                        Text(
                            text = "Dragusanu Marius Catalin - Leader",
                            style = Typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }

                Text(
                    text = "Project Coordinated by : ",
                    style = Typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp)) {

                        }
                        Text(
                            text = "Daniel Chis",
                            style = Typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(modifier = Modifier.size(8.dp)) {

                        }
                        Text(
                            text = "Mihai Caramihai",
                            style = Typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        Text(text = "Project Name ",color = MaterialTheme.colorScheme.onBackground.copy(0.25f))
                        Text(text = "Fostering the Transversal Digital Competences in Higher Education (Acronym: FTDCHE)" , color = MaterialTheme.colorScheme.onBackground)
                    }
                    Row {
                        Text(text = "Project Id ",color = MaterialTheme.colorScheme.onBackground.copy(0.25f))
                        Text(text = "2023-1-RO01- KA220-HED-000154433" ,color =  MaterialTheme.colorScheme.onBackground)
                    }
                }
            }
        }
    }
}
