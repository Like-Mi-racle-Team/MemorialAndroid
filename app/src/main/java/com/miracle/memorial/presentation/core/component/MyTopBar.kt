package com.miracle.memorial.presentation.core.component

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.miracle.memorial.R

@ExperimentalMaterial3Api
@Composable
fun MyTopBar() {
    val context = LocalContext.current

    TopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        actions = {
            IconButton(onClick = { Toast.makeText(context, "게시물 제작", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.ic_add_content), contentDescription = null)
            }
            IconButton(onClick = { Toast.makeText(context, "설정", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.ic_menu), contentDescription = null)
            }
        }
    )
}