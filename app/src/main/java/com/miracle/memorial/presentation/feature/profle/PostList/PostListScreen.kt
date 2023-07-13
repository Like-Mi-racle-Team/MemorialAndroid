package com.miracle.memorial.presentation.feature.profle.PostList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.feature.CommContent
import com.miracle.memorial.presentation.feature.CommContents
import com.miracle.memorial.presentation.feature.CommScreen

@Composable
fun PostListScreen() {
    Spacer(modifier = Modifier.height(30.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(CommContents) { content ->
            CommContent(writer = content.writer, createdTime = content.createdTime, content = content.content, id = content.image)
        }
    }
    Spacer(modifier = Modifier.height(160.dp))
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CommScreenPreview() {
    MemorialTheme() {
        PostListScreen()
    }
}