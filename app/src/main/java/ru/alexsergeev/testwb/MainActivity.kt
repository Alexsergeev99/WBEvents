package ru.alexsergeev.testwb

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.res.painterResource
import ru.alexsergeev.testwb.atoms.PeopleAvatar
import ru.alexsergeev.testwb.atoms.PeopleAvatarWithEdit
import ru.alexsergeev.testwb.atoms.Search
import ru.alexsergeev.testwb.molecules.MeetingCard
import ru.alexsergeev.testwb.molecules.OverlappingRow
import ru.alexsergeev.testwb.screens.AtomTestScreen
import ru.alexsergeev.testwb.screens.MoleculeTestScreen
import ru.alexsergeev.testwb.ui.theme.TestwbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            TestwbTheme {
//                AtomTestScreen()
                MoleculeTestScreen()
            }
        }
    }
}