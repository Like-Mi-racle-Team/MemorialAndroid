package com.miracle.memorial.presentation.feature.Home

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme

@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "jsw613님의\n행복한 순간들",
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(Happys) { happy ->
                Row {
                    HappyBox(happy)
                }
            }
        }
        Spacer(modifier = Modifier.height(160.dp))
    }
}

data class Happy(val day: String, val year: String, val id: Int)

val Happys = listOf(
    Happy("6월 9일", "2023년", R.drawable.img_1),
    Happy("6월 10일", "2023년", R.drawable.img_2),
    Happy("6월 11일", "2023년", R.drawable.img_3),
)

@Composable
fun HappyBox(
    happy: Happy,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(20.dp))
            .paint(
                painterResource(id = happy.id),
                contentScale = ContentScale.FillBounds),
        color = Color.Transparent
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = happy.day,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = happy.year,
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MemorialTheme() {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HappyBoxPreview() {
    MemorialTheme() {
        HappyBox(happy = Happy("6월 9일", "2023년", R.drawable.img_1))
    }
}


