package com.miracle.memorial.presentation.feature

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun CommScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "행복한 순간들을\n공유해보세요",
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(30.dp))
        CommContent(writer = "stev3j", createdTime = "6월 9일", content = "어쩌구저쩌구")
    }
}


@Composable
fun CommContent(
//    profile: Int,
    writer: String,
    createdTime: String,
//    images: List<Int>,
    content: String,
//    comments: List<Comments>
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = MColor.Container
    ) {
        Column {
            Row(
                modifier = Modifier.padding(start = 15.dp, top = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(MColor.TestImage)
                )
                Spacer(modifier = Modifier.width(11.dp))
                Column {
                    Text(
                        text = writer,
                        color = Color.Black,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = createdTime,
                        color = MColor.SubTitle,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .background(MColor.TestImage)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(15.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* todo */ }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* todo */ }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = content,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                text = "댓글 N개 모두 보기",
                color = MColor.SubTitle,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CommScreenPreview() {
    MemorialTheme() {
        CommScreen()
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CommContentPreview() {
    MemorialTheme() {
        CommContent(writer = "stev3j", createdTime = "6월 9일", content = "어쩌구저쩌구")
    }
}
