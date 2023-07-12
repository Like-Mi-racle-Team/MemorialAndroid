package com.miracle.memorial.presentation.core.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.feature.start.StartNavItem

@Composable
fun MyButton(onClick: () -> Unit, text: String) {
    Button(
        shape = RoundedCornerShape(10.dp),
        onClick = { onClick },
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 24.dp),
        colors = ButtonDefaults.buttonColors(MColor.PointColor)
    ) {
        Text(text = text, color = MColor.Background, style = MaterialTheme.typography.titleSmall)
    }
}