package ru.alexsergeev.presentation.ui.newComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.presentation.ui.atoms.Body1Text
import ru.alexsergeev.presentation.ui.atoms.Subheading1Text
import ru.alexsergeev.presentation.ui.molecules.GroupAvatarNew
import ru.alexsergeev.presentation.ui.molecules.PeopleAvatarNew
import ru.alexsergeev.presentation.ui.theme.NeutralActive

@Composable
fun PersonCardNew(
//    group: GroupUiModel,
//    goToCommunityScreen: (Int) -> Unit = {}
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC),
            Color(0xFFFBF0FD), Color(0xFFF9EFFD), Color(0xFFF8EEFE),
            Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )

    Box(
        modifier = Modifier
            .width(104.dp)
            .height(166.dp)
            .padding(vertical = 8.dp)
            .clickable {
//                goToCommunityScreen(group.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PeopleAvatarNew("https://s3-alpha-sig.figma.com/img/f32e/7373/028b1a961e2e3dcde2f9ea3584eab541?Expires=1724025600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Guex6xEF5ScGoBCQ5POg5OQFDpd8ppxei1DhNDAyHkY2utnLPiaM8MMDyaNUxzHuWoNPxv9RON4MMBByjtayxt846VLQkfVmRHXsG3QslXeoz1D3LrgzDeWy~OSuvMSz8gTkG0yqPJ-FIRbtMmgRD0p074zruzWwTa1Sru7KuQFOPNw5GKDWJhZ9xIVHxZ4sYwRm8klAfhkFIIppQqOo881Lyo6nysmUeGFgKx9XgFaPX-pDCjQXELbkhLSXVXfA-RhjD0LWZRNeGUHetlsTUTUPo8fQIX2GDd884~67wjVMnNROE4Hs-~wD0BclIIkBkpizJvK4rBbQ6GCG9YHX0Q__")
            Subheading1Text(
                text = "Саша",
                color = NeutralActive,
            )
            GradientButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp),
                gradient = gradient,
                text = "",
                isIconButton = true,
                shape = 8.dp
            )
        }
    }
}