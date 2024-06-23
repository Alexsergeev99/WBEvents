package ru.alexsergeev.testwb.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.atoms.Body1Text
import ru.alexsergeev.testwb.atoms.Metadata1Text
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralActive

@Composable
fun GroupCard(
    name: String,
    people: Long,
    groupLogo: Painter
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GroupAvatar(groupLogo)
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Body1Text(
                    modifier = Modifier.padding(2.dp),
                    text = name,
                    color = NeutralActive
                )
                Metadata1Text(
                    modifier = Modifier.padding(2.dp),
                    text = "$people человек",
                    color = Neutral
                )
            }
        }
    }
}