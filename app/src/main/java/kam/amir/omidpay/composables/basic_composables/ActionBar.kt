package kam.amir.omidpay.composables.basic_composables

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kam.amir.omidpay.R

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    noIcon: Boolean = false,
    icon: ImageVector = Icons.Default.KeyboardArrowLeft,
    title: String,
    onIconClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier
            .fillMaxSize(1f)
            .background(
                color = colorResource(id = R.color.white)
            )
    )
    {

        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (!noIcon)
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    modifier = Modifier.clickable { onIconClicked() }
                )
            else
                Spacer(modifier = Modifier.weight(0.2f))

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.weight(1.3f))

        }

        content()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ActionBarPreview() {
    ActionBar(title = "Products", onIconClicked = {}) {

    }
}