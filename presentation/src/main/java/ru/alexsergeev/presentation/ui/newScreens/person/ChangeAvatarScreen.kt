package ru.alexsergeev.presentation.ui.newScreens.person

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.newComponents.GradientButton
import ru.alexsergeev.presentation.ui.theme.EventsTheme

@Composable
fun ChangeAvatarScreen(navController: NavController) {
    val context = LocalContext.current
    var imageUri: Any? by remember { mutableStateOf(R.drawable.examplephoto) }
    var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {
        if (it != null) {
            imageUri = it
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }
    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxItems = 2)
    ) {
        if (it != null) {
            Log.d("PhotoPicker", "Selected URI: $it")
            selectedImageUris = it
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
                .clickable {
                    navController.navigateUp()
                },
            painter = painterResource(id = R.drawable.close),
            contentDescription = "close",
            tint = Color.White
        )
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clickable {
                    photoPicker.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                },
            model = ImageRequest.Builder(LocalContext.current).data(imageUri)
                .crossfade(enable = true).build(),
            contentDescription = "Avatar Image",
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                TextButton(onClick = {
                    photoPicker.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                }
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "Выбрать другое фото",
                        style = EventsTheme.typography.subheading1,
                        color = EventsTheme.colors.weakColor
                    )
                }
            }
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                GradientButton(
                    modifier = Modifier
                        .width(350.dp)
                        .height(50.dp),
                    isTextButton = true,
                    text = "Сохранить",
                    shape = 28.dp,
                    onClick = {
                    }
                )
            }
        }
    }
}