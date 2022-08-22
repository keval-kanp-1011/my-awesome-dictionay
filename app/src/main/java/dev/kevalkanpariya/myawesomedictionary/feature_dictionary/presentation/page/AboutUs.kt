package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.presentation.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AboutUs() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text("How to use My Awesome Dictionary", fontWeight = FontWeight.Bold)
        Text("How to Change Language", fontWeight = FontWeight.Bold)
        Text("How to On Dark Mode", fontWeight = FontWeight.Bold)
    }
}