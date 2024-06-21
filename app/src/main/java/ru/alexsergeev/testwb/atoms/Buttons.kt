package ru.alexsergeev.testwb.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.ui.theme.AlmostTransparent
import ru.alexsergeev.testwb.ui.theme.LightPink
import ru.alexsergeev.testwb.ui.theme.Purple40
import ru.alexsergeev.testwb.ui.theme.Purple50
import ru.alexsergeev.testwb.ui.theme.Purple80

@Composable
fun Buttons() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Purple50),
                onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = 1.dp, color = Purple50),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple50
                )
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple50
                )
            }
        }
        Row {
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Purple40),
                onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = 1.dp, color = Purple40),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple40
                )
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple40
                )
            }
        }
        Row {
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .border(
                    BorderStroke(width = 6.dp, color = AlmostTransparent),
                    shape = RoundedCornerShape(100)
                )
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Purple50),
                onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            OutlinedButton(modifier = Modifier
                .border(
                    width = 6.dp,
                    color = AlmostTransparent,
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                ),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = 1.dp, color = Purple50),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple50
                )
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15))
                .border(
                    BorderStroke(width = 6.dp, color = AlmostTransparent),
                    shape = RoundedCornerShape(100)
                ),
//                    border = BorderStroke(width = 4.dp, color = AlmostTransparent),
                colors = ButtonDefaults.buttonColors(LightPink),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple50
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Purple80),
                onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = 1.dp, color = Purple80),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple80
                )
            }
            Button(modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 6.dp,
                    top = 2.dp,
                    bottom = 3.dp
                )
//                .padding(8.dp)
                .clip(RoundedCornerShape(15)),
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Button",
                    color = Purple80
                )
            }
        }
    }
}