package com.miracle.memorial.presentation.feature.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.root.MainScreen

@ExperimentalMaterial3Api
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemorialTheme {
                StartScreen()
            }
        }
    }
}

@Composable
fun StartScreen() {
    Column() {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.img_memorial),
            contentDescription = null,
            modifier = Modifier.size(670.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "로그인")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "메모리얼 계정이 없다면?"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "회원가입",
                color = MColor.Text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable { /*TODO*/ }
            )
        }
    }
}