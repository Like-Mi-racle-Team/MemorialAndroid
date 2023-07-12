package com.miracle.memorial.presentation.feature.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.telephony.SmsMessage.MessageClass
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.component.MyButton
import com.miracle.memorial.presentation.core.component.MyTopBar
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavBar
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavGraph
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.root.MainScreen

@ExperimentalMaterial3Api
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemorialTheme {
                StartScreens()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun StartScreens() {
    val navController = rememberNavController()

    Scaffold {
        StartNavGraph(navController = navController)
    }
}

@Composable
fun StartScreen(navController: NavController) {
    Surface(
        color = MColor.Background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.img_memorial),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1.5f))
            MyButton(
                onClick = { navController.navigate(StartNavItem.login) },
                text = "로그인"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "메모리얼 계정이 없다면?",
                    color = MColor.HintText,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "회원가입",
                    color = MColor.Text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable { navController.navigate(StartNavItem.signup_first) }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    MemorialTheme() {
        StartScreens()
    }
}