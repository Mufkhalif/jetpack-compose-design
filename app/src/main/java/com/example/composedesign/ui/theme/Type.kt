package com.example.composedesign.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composedesign.R

// Set of Material typography styles to start with


val fonts = FontFamily(
    Font(R.font.product_sans_bold, weight = FontWeight.Bold),
    Font(R.font.product_sans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.product_sans_regular, weight = FontWeight.Normal),
    Font(R.font.product_sans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = black
    ),
    h1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = black
    ),
    h2 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = black
    ),
    h3 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = black
    ),
    subtitle1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = placeholder
    )
)