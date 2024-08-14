package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.Body2Text
import ru.alexsergeev.presentation.ui.atoms.OneChipNew
import ru.alexsergeev.presentation.ui.atoms.Subheading1Text
import ru.alexsergeev.presentation.ui.models.EventUiModel
import ru.alexsergeev.presentation.ui.molecules.EventAvatarInProfileScreen
import ru.alexsergeev.presentation.ui.molecules.EventAvatarMax
import ru.alexsergeev.presentation.ui.molecules.EventAvatarMini
import ru.alexsergeev.presentation.ui.theme.EventsTheme
import ru.alexsergeev.presentation.ui.theme.NeutralActive
import ru.alexsergeev.presentation.ui.theme.NeutralWeak

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNew(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(306.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            EventAvatarMax("https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LDkX4hg2Rih1PmRNu3V0585bNrmoR1pulfVU1HAieCgql27O474YsQm5HBH8-nZ4BE3z5V2SkVuWGB72MLHX6QMfSwfU7jZQ6rQLbrUAT1w0mpxpLk~ygLT7l~lPAX9Lbk77HuXs4OsQGLuGK-gAMJ2r6qmKkpfrPyuJRhy~XSFqniVMKW~PUCvEW5ohHKE2OWQN722JrU~i6rtMtV16UgMNTuIrhkg7ggSbZp9fpraHmHoHFJ5SMOL6Si0kEKhZReBvZgJBgxOJtmtzmMUAxUrJJNg1PNqkKxCKjkUmEQdZBghGW295O5sxMTLAnsilRcXWCJ8kqb~838GxVqU2KA__")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "Python Days",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Body1Text(text = "10 августа · Кожевенная линия, 40", color = NeutralWeak)
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewBig(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(306.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            EventAvatarMax("https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LDkX4hg2Rih1PmRNu3V0585bNrmoR1pulfVU1HAieCgql27O474YsQm5HBH8-nZ4BE3z5V2SkVuWGB72MLHX6QMfSwfU7jZQ6rQLbrUAT1w0mpxpLk~ygLT7l~lPAX9Lbk77HuXs4OsQGLuGK-gAMJ2r6qmKkpfrPyuJRhy~XSFqniVMKW~PUCvEW5ohHKE2OWQN722JrU~i6rtMtV16UgMNTuIrhkg7ggSbZp9fpraHmHoHFJ5SMOL6Si0kEKhZReBvZgJBgxOJtmtzmMUAxUrJJNg1PNqkKxCKjkUmEQdZBghGW295O5sxMTLAnsilRcXWCJ8kqb~838GxVqU2KA__")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "Python Days",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Body1Text(text = "10 августа · Кожевенная линия, 40", color = NeutralWeak)
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewMini(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(148.dp)
            .height(344.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EventAvatarMini("https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LDkX4hg2Rih1PmRNu3V0585bNrmoR1pulfVU1HAieCgql27O474YsQm5HBH8-nZ4BE3z5V2SkVuWGB72MLHX6QMfSwfU7jZQ6rQLbrUAT1w0mpxpLk~ygLT7l~lPAX9Lbk77HuXs4OsQGLuGK-gAMJ2r6qmKkpfrPyuJRhy~XSFqniVMKW~PUCvEW5ohHKE2OWQN722JrU~i6rtMtV16UgMNTuIrhkg7ggSbZp9fpraHmHoHFJ5SMOL6Si0kEKhZReBvZgJBgxOJtmtzmMUAxUrJJNg1PNqkKxCKjkUmEQdZBghGW295O5sxMTLAnsilRcXWCJ8kqb~838GxVqU2KA__")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column() {
                    Text(
                        text = "Python Days",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Text(
                        maxLines = 3,
                        text = "10 августа · Кожевенная линия, 40",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralWeak)
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewInEventScreen(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(148.dp)
            .height(294.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EventAvatarMini("https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LDkX4hg2Rih1PmRNu3V0585bNrmoR1pulfVU1HAieCgql27O474YsQm5HBH8-nZ4BE3z5V2SkVuWGB72MLHX6QMfSwfU7jZQ6rQLbrUAT1w0mpxpLk~ygLT7l~lPAX9Lbk77HuXs4OsQGLuGK-gAMJ2r6qmKkpfrPyuJRhy~XSFqniVMKW~PUCvEW5ohHKE2OWQN722JrU~i6rtMtV16UgMNTuIrhkg7ggSbZp9fpraHmHoHFJ5SMOL6Si0kEKhZReBvZgJBgxOJtmtzmMUAxUrJJNg1PNqkKxCKjkUmEQdZBghGW295O5sxMTLAnsilRcXWCJ8kqb~838GxVqU2KA__")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column() {
                    Text(
                        text = "Python Days",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Text(
                        maxLines = 3,
                        text = "10 августа · Кожевенная линия, 40",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralWeak)
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardNewInProfileScreen(
    event: EventUiModel,
    goToEventScreen: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(212.dp)
            .height(294.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clickable {
                goToEventScreen(event.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EventAvatarInProfileScreen("https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LDkX4hg2Rih1PmRNu3V0585bNrmoR1pulfVU1HAieCgql27O474YsQm5HBH8-nZ4BE3z5V2SkVuWGB72MLHX6QMfSwfU7jZQ6rQLbrUAT1w0mpxpLk~ygLT7l~lPAX9Lbk77HuXs4OsQGLuGK-gAMJ2r6qmKkpfrPyuJRhy~XSFqniVMKW~PUCvEW5ohHKE2OWQN722JrU~i6rtMtV16UgMNTuIrhkg7ggSbZp9fpraHmHoHFJ5SMOL6Si0kEKhZReBvZgJBgxOJtmtzmMUAxUrJJNg1PNqkKxCKjkUmEQdZBghGW295O5sxMTLAnsilRcXWCJ8kqb~838GxVqU2KA__")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Column() {
                    Text(
                        text = "Python Days",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralActive,
                    )
                    Text(
                        maxLines = 3,
                        text = "10 августа · Кожевенная линия, 40",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeutralWeak)
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                        OneChipNew("Тестирование")
                    }
                }
            }
        }
    }
}