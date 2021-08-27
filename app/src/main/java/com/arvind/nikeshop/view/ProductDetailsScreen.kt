package com.arvind.nikeshop.view

import android.widget.RatingBar
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.arvind.nikeshop.R
import com.arvind.nikeshop.component.TopAppBarWithBack
import com.arvind.nikeshop.ui.theme.*

@Preview(showBackground = true)
@Composable
fun ProductDetailsScreen() {
    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {

                },
            )
        }, backgroundColor = lightgraybg,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = orange
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add To Cart",
                    tint = white
                )
            }
        },

        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                ConstraintLayout {
                    val (imagesliderref, addtocartref) = createRefs()
                    Box(modifier = Modifier
                        .height(280.dp)
                        .constrainAs(imagesliderref) {
                            top.linkTo(imagesliderref.top)
                            bottom.linkTo(imagesliderref.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                        HeaderImagesSlider()
                    }
                    Surface(
                        color = white,
                        shape = RoundedCornerShape(40.dp)
                            .copy(
                                bottomStart = ZeroCornerSize,
                                bottomEnd = ZeroCornerSize
                            ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ) {
                            ProductTitle()
                            Spacer(modifier = Modifier.padding(10.dp))
                            ProductAvailableSize()
                            Spacer(modifier = Modifier.padding(10.dp))
                            ProductItemColorWithDesc()
                        }


                    }

                }

            }
        }
    )

}


@Composable
fun HeaderImagesSlider() {
    val showThumbImagesList = listOf<Int>(
        R.drawable.show_1,
        R.drawable.shoe_thumb_1,
        R.drawable.shoe_thumb_4,
        R.drawable.shoe_thumb_3
    )
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.show_1),
            contentDescription = "",
            modifier = Modifier
                .size(230.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(showThumbImagesList.size) { item ->
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(62.dp)
                        .border(
                            color = if (item == 0) orange else lightGrey,
                            width = 2.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable { }) {
                    Image(
                        painter = painterResource(showThumbImagesList[item]),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                            .padding(
                                start = 10.dp,
                                end = 5.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                    )

                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun ProductTitle() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = grey,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "NIKE AIR MAX 200",
                color = titleTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                orange,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("$ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ) {
                            append("240")
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    fontSize = 16.sp

                )


            }
        }
    }
}

@Composable
fun ProductAvailableSize() {
    val itemListavailablesize = listOf("US6", "US7", "US8", "US9")
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Available Sizes",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(itemListavailablesize.size) { item ->
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(70.dp)
                        .border(
                            color = if (item == 1) orange else lightGrey,
                            width = 2.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable { }) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 16.dp,
                                top = 10.dp,
                                bottom = 8.dp
                            ),
                        text = itemListavailablesize[item],
                        fontWeight = FontWeight.Bold,
                        color = if (item == 1) titleTextColor else Color.LightGray
                    )


                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun ProductItemColorWithDesc() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Color",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(orange)
                    .clickable { }
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(lightBlue)
                    .clickable { }
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(black)
                    .clickable { }
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(red)
                    .clickable { }
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(skyBlue)
                    .clickable { }
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Description",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.product_text_description),
            color = lightblack,
            fontSize = 14.sp
        )
    }

}





