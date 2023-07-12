package com.miracle.memorial.presentation.feature.start

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.SmsMessage.MessageClass
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
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
//                LoadImagePermission()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun StartScreens() {
    /* 만약 로그인 토큰이 만료되었다면 */
    val navController = rememberNavController()

    StartNavGraph(navController = navController)

    /* 토큰을 가지고 있다면 */
    
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


@Composable
fun LoadImagePermission() {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetMultipleContents()) { uriList: List<Uri?> ->
        imageUri = uriList[0]
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MColor.Background)
    ) {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick image")
        }

        Spacer(modifier = Modifier.height(12.dp))

        imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver,it)

            } else {
                val source = ImageDecoder
                    .createSource(context.contentResolver,it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let { btm ->
                Image(bitmap = btm.asImageBitmap(),
                    contentDescription =null,
                    modifier = Modifier.size(400.dp))
            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun LoadImagePreview() {
//    MemorialTheme {
//        LoadImagePermission()
//    }
//}