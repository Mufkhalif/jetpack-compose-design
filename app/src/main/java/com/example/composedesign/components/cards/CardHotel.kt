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
import coil.annotation.ExperimentalCoilApi
import com.example.composedesign.R
import com.example.composedesign.ui.theme.green
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalCoilApi
@Composable
fun CardHotel(title: String, location: String, price: String, url: String) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Box(
                modifier = Modifier
                    .height(171.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = url,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth,
                    shimmerParams = ShimmerParams(
                        baseColor = MaterialTheme.colors.background,
                        highlightColor = Color.White,
                        durationMillis = 350,
                        dropOff = 0.65f,
                        tilt = 20f
                    ),
                    failure = {
                        Text(text = "image request failed.")
                    })
                Box(modifier = Modifier.padding(12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "icon favorite",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "icon location",
                modifier = Modifier
                    .width(14.dp)
                    .height(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = location,
                style = MaterialTheme.typography.subtitle1,
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = price,
                style = MaterialTheme.typography.subtitle1,
                color = green
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "/Bulan",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}
