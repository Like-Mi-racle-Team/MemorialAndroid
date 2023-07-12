package com.miracle.memorial.presentation.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miracle.memorial.R
import com.miracle.memorial.presentation.core.component.MyButton
import com.miracle.memorial.presentation.core.component.MyTextField
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.core.theme.Pretendard
import com.miracle.memorial.presentation.feature.start.StartNavItem
import com.miracle.memorial.presentation.feature.start.StartScreen

@ExperimentalMaterial3Api
@Composable
fun SignupFirstScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = null,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(46.dp))
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "아이디를\n입력해주세요",
            color = MColor.Text,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(40.dp))

        MyTextField(label = "아이디", maxChar = 16)

        Spacer(modifier = Modifier.weight(1f))
        MyButton(onClick = { navController.navigate(StartNavItem.signup_second) }, text = "다음")
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@ExperimentalMaterial3Api
@Composable
fun SignupSecondScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = null,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(46.dp))
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "비밀번호를\n입력해주세요",
            color = MColor.Text,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(40.dp))

        MyTextField(label = "비밀번호", maxChar = 24)
        Spacer(modifier = Modifier.height(30.dp))
        MyTextField(label = "비밀번호 확인", maxChar = 24)

        Spacer(modifier = Modifier.weight(1f))
        MyButton(onClick = { navController.navigate(StartNavItem.signup_third) }, text = "다음")
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@ExperimentalMaterial3Api
@Composable
fun SignupThirdScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = null,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(46.dp))
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "메모리얼 닉네임을\n입력해주세요",
            color = MColor.Text,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(40.dp))

        MyTextField(label = "닉네임", maxChar = 16)

        Spacer(modifier = Modifier.weight(1f))
        MyButton(onClick = { /*TODO*/ }, text = "메모리얼 시작하기")
        Spacer(modifier = Modifier.height(24.dp))
    }
}

/* Preview */

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SignupFirstScreenPreview() {
    val navController = rememberNavController()

    MemorialTheme() {
        SignupFirstScreen(navController = navController)
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SignupSecondScreenPreview() {
    val navController = rememberNavController()

    MemorialTheme() {
        SignupSecondScreen(navController = navController)
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SignupThirdScreenPreview() {
    val navController = rememberNavController()

    MemorialTheme() {
        SignupThirdScreen(navController = navController)
    }
}


