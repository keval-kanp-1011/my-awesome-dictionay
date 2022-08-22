package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.myawesomedictionary.R


@Preview
@Composable
fun Drawer() {
    Column(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_settings), contentDescription = null)
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Settings",)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_info_24), contentDescription = null)
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "About Us")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_policy_24), contentDescription = null)
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Privacy Policy")
        }
    }

}