package com.arvind.nikeshop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arvind.nikeshop.R
import com.arvind.nikeshop.ui.theme.lightSilver
import com.arvind.nikeshop.ui.theme.orange
import com.arvind.nikeshop.ui.theme.white

@Preview(showBackground = true)
@Composable
fun BottomBar() {
    BottomAppBar(
            backgroundColor = white,
            elevation = 0.dp
    ) {
        Icon(
                painter = painterResource(R.drawable.ic_baseline_home_24),
                tint = lightSilver,
                contentDescription = "",
                modifier = Modifier
                        .weight(1f)
                        .size(20.dp, 20.dp)
        )
        Icon(
                painter = painterResource(R.drawable.ic_baseline_search_24),
                tint = lightSilver,
                contentDescription = "",
                modifier = Modifier
                        .weight(1f)
                        .size(20.dp, 20.dp)
        )
        Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                        .weight(1f)
        ) {
            Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                            .clip(CircleShape)
                            .background(orange)
                            .size(44.dp, 44.dp)


            ) {
                Icon(
                        painter = painterResource(R.drawable.ic_baseline_shopping_cart_24),
                        tint = white,
                        contentDescription = "",
                        modifier = Modifier
                                .size(20.dp, 20.dp)
                )
            }

        }

        Icon(
                painter = painterResource(R.drawable.ic_baseline_favorite_border_24),
                tint = lightSilver,
                contentDescription = "",
                modifier = Modifier
                        .weight(1f)
                        .size(20.dp, 20.dp)
        )


    }

}