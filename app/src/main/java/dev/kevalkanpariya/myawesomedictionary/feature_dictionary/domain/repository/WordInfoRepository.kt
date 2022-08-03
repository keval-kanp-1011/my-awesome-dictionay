package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.repository

import dev.kevalkanpariya.myawesomedictionary.core.util.Resource
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}