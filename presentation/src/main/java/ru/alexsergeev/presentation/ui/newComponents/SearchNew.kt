package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.wbevents.ui.utils.MaskVisualTransformation

@Composable
internal fun SearchNew(
    hint: String,
    hintColor: Color = EventsTheme.colors.weakColor,
    isSearch: Boolean = true,
    padding: Dp = 8.dp,
    isEnabled: (Boolean) = true,
    height: Dp = 56.dp,
    width: Dp = 344.dp,
    cornerShape: Shape = RoundedCornerShape(18.dp),
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
    text: MutableState<String> = remember { mutableStateOf("") }
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color.White, EventsTheme.colors.disabledComponent
        )
    )

    Row(
        modifier = Modifier
            .padding(vertical = padding)
            .height(height)
            .width(width)
            .background(gradient, shape = cornerShape)
            .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(gradient, shape = CircleShape)
                .clickable {
                    if (text.value.isNotEmpty()) {
                        text.value = ""
                        onTextChange("")
                    }
                },
        ) {
            if (isSearch) {
                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    painter = painterResource(id = R.drawable.search_new),
                    contentDescription = null,
                    tint = EventsTheme.colors.weakColor
                )
            }
        }
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .background(gradient),
            value = text.value,
            onValueChange = {
                text.value = it
                onTextChange(it)
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left,
                color = NeutralActive
            ),
            decorationBox = { innerTextField ->
                if (text.value.isEmpty()) {
                    Text(
                        text = hint,
                        color = hintColor,
                        style = EventsTheme.typography.bodyText1
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
            singleLine = true,
        )
    }
}