package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.model

import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
