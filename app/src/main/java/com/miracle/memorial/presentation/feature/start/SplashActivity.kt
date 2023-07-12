package com.miracle.memorial.presentation.feature.start

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.root.MainActivity
import com.miracle.memorial.presentation.root.MainScreen
import kotlinx.coroutines.delay

@ExperimentalMaterial3Api
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            delay(3000)

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
