package ru.alexsergeev.testwb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Heading2Text
import ru.alexsergeev.testwb.atoms.SimpleOutlinedButton
import ru.alexsergeev.testwb.atoms.Subheading1Text
import ru.alexsergeev.testwb.atoms.Subheading2Text
import ru.alexsergeev.testwb.molecules.PeopleAvatar
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(6.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.navigate_back),
                    contentDescription = "back"
                )
                Subheading1Text(
                    modifier = Modifier
                        .padding(6.dp),
                    text = "Профиль",
                    color = NeutralActive
                )
            }
            Icon(
                modifier = Modifier
                    .padding(6.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "edit"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier
                .height(48.dp)
                .fillMaxWidth())
            PeopleAvatar(image = R.drawable.avatar_icon, padding = 20.dp)
            Heading2Text(text = "Иван Иванов", color = NeutralActive)
            Subheading2Text(text = "+7 999 999 99-99", color = Neutral)
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                SimpleOutlinedButton(text = "", width = 80.dp)
                SimpleOutlinedButton(text = "", width = 80.dp)
                SimpleOutlinedButton(text = "", width = 80.dp)
                SimpleOutlinedButton(text = "", width = 80.dp)
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()) {
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                            .fillMaxWidth()
                            .background(NeutralBackground)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.box),
                            contentDescription = "box"
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.people),
                            contentDescription = "people"
                        )
                        Body1Text(text = "Еще", color = NeutralActive)
                    }
                }
            }
        }
    }
}