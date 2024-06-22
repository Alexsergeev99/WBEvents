package ru.alexsergeev.testwb.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.alexsergeev.testwb.ui.theme.Neutral
import ru.alexsergeev.testwb.ui.theme.NeutralBackground

@Composable
fun Search(text: String) {
    val searchText = rememberSaveable { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        contentAlignment = Alignment.Center) {
        TextField(
            modifier = Modifier
//            .fillMaxWidth(0.7f)
                .width(326.dp)
                .height(36.dp)
                .padding(start = 4.dp, end = 4.dp),
            value = searchText.value,
            shape = RoundedCornerShape(4.dp),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Neutral
                )
            },
            label = {
                Body1Text(text = text, color = Neutral)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Neutral,
                focusedContainerColor = NeutralBackground,
                unfocusedTextColor = Neutral,
                unfocusedContainerColor = NeutralBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            onValueChange = {
                searchText.value = it
            },
        )
    }
}