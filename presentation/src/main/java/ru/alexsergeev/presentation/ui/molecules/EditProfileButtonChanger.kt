package ru.alexsergeev.presentation.ui.molecules

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexsergeev.domain.domain.models.PersonUiModel
import ru.alexsergeev.presentation.R
import ru.alexsergeev.presentation.ui.atoms.DisabledButton
import ru.alexsergeev.presentation.ui.atoms.SimpleButton

private const val TOAST_NO_NAME_TEXT = "Как же на встречу и без имени?"

@Composable
internal fun EditProfileButtonChanger(navController: NavController, person: PersonUiModel) {

    val ctx = LocalContext.current
    val focusManager = LocalFocusManager.current

    if (person.name.firstName.isNotEmpty()) {
        SimpleButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            text = stringResource(id = R.string.save),
            padding = 30.dp,
            onClick = {
                focusManager.clearFocus()
                navController.navigate("navigation")
            }
        )
    } else {
        DisabledButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            text = stringResource(id = R.string.save),
            padding = 30.dp,
            onClick = {
                Toast.makeText(ctx, TOAST_NO_NAME_TEXT, Toast.LENGTH_LONG)
                    .show()
            }
        )
    }
}