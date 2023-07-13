package com.miracle.memorial.presentation.feature.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.theme.MemorialTheme

@ExperimentalMaterial3Api
@Composable
fun ItemClickScreen() {
    LazyRow() {
        items(Images) { imageId ->
            Image(
                modifier = Modifier.fillMaxHeight(),
                painter = painterResource(id = imageId),
                contentDescription = null
            )
        }
    }

}

val Images = listOf(
    R.drawable.img_1, R.drawable.img_2, R.drawable.img_3
)

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ItemClickScreenPreview() {
    MemorialTheme() {
        ItemClickScreen()
    }
}