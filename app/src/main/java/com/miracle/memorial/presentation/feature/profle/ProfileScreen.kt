package com.miracle.memorial.presentation.feature

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "stev3j",
                        color = MColor.Text,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { /* todo */ }
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Row {
                    Text(
                        text = "게시물",
                        color = MColor.Text,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "?개",
                        color = MColor.Text,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MColor.TestImage)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "안녕하세요, 조승완입니다.",
            color = MColor.Text,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(20.dp))

        var state by remember { mutableStateOf(0) }
        val tabs = listOf("게시물", "댓글")

        /* TapRow */

        TabRow(
            contentColor = MColor.Text,
            containerColor = MColor.Background,
            selectedTabIndex = state,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[state])
                        .height(3.dp)
                        .padding(horizontal = 70.dp)
                        .background(color = MColor.Text, shape = RoundedCornerShape(30.dp))
                )
            },
            divider = { Box(modifier = Modifier
                .height(1.dp)
                .background(MColor.Container)) },
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selectedContentColor = MColor.Text,
                    unselectedContentColor = MColor.HintText,
                    text = {
                        Text(
                            text = title,
                            color = MColor.Text,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
//        when (state) {
//            0 -> null
//            1 -> null
//        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MemorialTheme() {
        ProfileScreen()
    }
}