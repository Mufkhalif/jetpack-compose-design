package com.example.composedesign.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composedesign.R


@ExperimentalCoilApi
@Composable
fun CardCity(title: String, restCount: String, url: String) {
    Card(modifier = Modifier.padding(end = 12.dp), shape = RoundedCornerShape(16.dp)) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
        ) {
            Image(
                painter = rememberImagePainter(url),
                contentDescription = "image city",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(text = title, color = Color.White)
                        Text(
                            text = restCount,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "icon favorite"
                    )
                }
            }
        }
    }
}