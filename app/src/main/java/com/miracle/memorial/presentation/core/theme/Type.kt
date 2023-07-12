package com.miracle.memorial.presentation.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.miracle.memorial.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold)
)

val Typography = Typography(

    /* title */

    titleLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    /* body */

    bodyLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),

    /* label */

    labelLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)