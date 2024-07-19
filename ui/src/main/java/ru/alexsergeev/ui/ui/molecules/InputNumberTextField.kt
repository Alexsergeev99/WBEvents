package ru.alexsergeev.ui.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.testwb.R
import ru.alexsergeev.ui.ui.theme.EventsTheme
import ru.alexsergeev.ui.ui.theme.Neutral
import ru.alexsergeev.ui.ui.theme.NeutralActive
import ru.alexsergeev.ui.ui.theme.NeutralBackground
import kotlin.math.absoluteValue

@Composable
fun InputNumberTextField(
    hint: String,
    padding: Dp = 8.dp,
    isEnabled: (Boolean) = true,
    height: Dp = 36.dp,
    width: Dp = 326.dp,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = NeutralBackground,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {

    val number = remember {
        mutableStateOf("")
    }

    val mask = MaskVisualTransformation("(###) ### ##-##")

    Row(
        modifier = Modifier
            .padding(vertical = padding)
            .height(height)
            .width(width)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(color = backgroundColor, shape = CircleShape)
                .clickable {
                    if (number.value.isNotEmpty()) {
                        number.value = ""
                        onTextChange("")
                    }
                },
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(backgroundColor),
                value = number.value,
                onValueChange = {
                    number.value = it
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
                cursorBrush = SolidColor(NeutralActive),
                decorationBox = { innerTextField ->
                    if (number.value.isEmpty()) {
                        Text(text = hint, color = Neutral, style = EventsTheme.typography.bodyText1)
                    }
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
                singleLine = true,
                visualTransformation = mask
            )
        }
    }
}

class MaskVisualTransformation(private val mask: String) : VisualTransformation {
    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}