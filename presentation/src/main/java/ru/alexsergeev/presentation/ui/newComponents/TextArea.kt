package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
fun Textarea(
    hint: String,
    onTextChange: (String) -> Unit = {},
) {
    val gradient = Brush.horizontalGradient(
        listOf(
            Color.White, EventsTheme.colors.disabledComponent
        )
    )
    val text = rememberSaveable { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .width(344.dp)
            .background(gradient, shape = RoundedCornerShape(18.dp))
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                onTextChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp)
                .background(gradient),
            textStyle = EventsTheme.typography.subheading1,
//            TextStyle(
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
//                fontWeight = FontWeight.SemiBold,
//                textAlign = TextAlign.Left,
//                color = NeutralActive
//            ),
            decorationBox = { innerTextField ->
                if (text.value.isEmpty()) {
                    Text(
                        text = hint,
                        color = EventsTheme.colors.weakColor,
                        style = EventsTheme.typography.bodyText1
                    )
                }
                innerTextField()
            },
        )
    }
}