package com.miracle.memorial.presentation.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.memorial.presentation.core.theme.MColor
import com.miracle.memorial.presentation.core.theme.Pretendard

@ExperimentalMaterial3Api
@Composable
fun MyTextField(label: String, maxChar: Int) {
    var text by rememberSaveable { mutableStateOf("Text") }

    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        //External label
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = MColor.HintText,
            style = MaterialTheme.typography.labelMedium
        )

        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChar) text = it
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
//                backgroundColor = MColor.Background,
                cursorColor = MColor.Text,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        //counter message
        Text(
            text = "${text.length} / $maxChar",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            color = MColor.HintText,
            style = MaterialTheme.typography.labelMedium, //use the caption text style

        )
    }
}