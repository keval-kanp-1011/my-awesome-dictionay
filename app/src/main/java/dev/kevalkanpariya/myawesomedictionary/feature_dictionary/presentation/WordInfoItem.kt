package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.presentation

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.myawesomedictionary.R
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.model.WordInfo

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = wordInfo.phonetic!!, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))


        wordInfo.phonetics.forEach{ phonetic ->
            Row() {
                Text(text = phonetic.text!!,fontWeight = FontWeight.Medium)
                Icon(
                    painter = painterResource(id = R.drawable.ic_audio),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        val player = MediaPlayer()
                        try {
                            player.setAudioStreamType(AudioManager.STREAM_MUSIC)
                            player.setDataSource(phonetic.audio)
                            player.prepare()
                            player.start()
                        } catch (e: Exception) {

                        }

                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        wordInfo.meanings.forEach { meaning ->
            Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)
            meaning.definitions.forEachIndexed { i, definition ->
                Text(text = "${i + 1}. ${definition.definition}")
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text(text = "Example: $example", color = Color.Red)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}