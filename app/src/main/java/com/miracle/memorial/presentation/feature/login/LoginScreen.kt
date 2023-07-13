package com.miracle.memorial.presentation.feature.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miracle.memorial.R
import com.miracle.memorial.domain.model.LoginDto
import com.miracle.memorial.presentation.core.component.MyButton
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.core.theme.Pretendard
import com.miracle.memorial.presentation.feature.start.StartActivity
import com.miracle.memorial.presentation.feature.start.StartNavItem
import com.miracle.memorial.presentation.feature.start.StartScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    var idPwdNotSame by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

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
            text = "로그인해주세요",
            color = MColor.Text,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(40.dp))

        var id by rememberSaveable { mutableStateOf("") }
        val idMaxChar = 16

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = "아이디",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = MColor.HintText,
                style = MaterialTheme.typography.labelMedium
            )
            TextField(
                value = id,
                onValueChange = {
                    if (it.length <= idMaxChar) id = it
                },
                textStyle = TextStyle(
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Light,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MColor.Background,
                    cursorColor = MColor.Text,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Text(
                text = "${id.length} / $idMaxChar",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                color = MColor.HintText,
                style = MaterialTheme.typography.labelMedium,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        var pwd by rememberSaveable { mutableStateOf("") }
        val pwdMaxChar = 24

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = "비밀번호",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = MColor.HintText,
                style = MaterialTheme.typography.labelMedium
            )
            TextField(
                value = pwd,
                onValueChange = {
                    if (it.length <= pwdMaxChar) pwd = it
                },
                textStyle = TextStyle(
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Light,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MColor.Background,
                    cursorColor = MColor.Text,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Text(
                text = "${pwd.length} / $pwdMaxChar",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                color = MColor.HintText,
                style = MaterialTheme.typography.labelMedium,
            )
            if (idPwdNotSame) {
                Toast.makeText(context, "아이디 또는 비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        MyButton(onClick = {
//            loginViewModel.login(LoginDto(userId = id, userPassword = pwd, userName = null, userIntroduce = null))

            if (id == "jsw613" && pwd == "jsw613") {
                Toast.makeText(context, "jsw613님 안녕하세요!", Toast.LENGTH_SHORT).show()
                navController.navigate(StartNavItem.main)
            } else {

                idPwdNotSame = true
            }
        }, text = "메모리얼 시작하기")
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()

    MemorialTheme() {
        LoginScreen(navController = navController)
    }
}