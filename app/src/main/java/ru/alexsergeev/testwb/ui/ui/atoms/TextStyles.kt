package ru.alexsergeev.testwb.ui.ui.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextStyles() {

    val testText = "The quick brown fox jumps over the lazy dog"

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        LazyRow {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 32.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Heading 1",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black,
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/32/Bold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Heading1Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 32.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Heading 2",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/24/Bold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Heading2Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Subheading 1",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/18/SemiBold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Subheading1Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Subheading 2",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/16/SemiBold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Subheading2Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Body Text 1",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/14/SemiBold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Body1Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 12.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Body Text 2",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/14/Regular",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Body2Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 12.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Metadata 1",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/12/Regular",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Metadata1Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 12.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Metadata 2",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/10/Regular",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Metadata2Text(text = testText)
            }
        }
        LazyRow {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "Metadata 3",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(2.dp),
                        text = "SF Pro Display/10/SemiBold",
                        fontSize = 16.sp,
                        color = Color.Gray,
                    )
                }
                Metadata3Text(text = testText)
            }
        }
    }
}

@Composable
fun Heading1Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 32.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Heading2Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Subheading1Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 18.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Subheading2Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Body1Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Body2Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Metadata1Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Metadata2Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 10.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Left,
        color = color,
    )
}

@Composable
fun Metadata3Text(modifier: Modifier = Modifier, text: String, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 10.sp,
        fontFamily = FontFamily(Font(ru.alexsergeev.testwb.R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Left,
        color = color,
    )
}