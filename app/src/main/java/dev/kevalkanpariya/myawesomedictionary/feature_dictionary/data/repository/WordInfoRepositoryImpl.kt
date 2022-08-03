package dev.kevalkanpariya.myawesomedictionary.feature_dictionary.data.repository

import dev.kevalkanpariya.myawesomedictionary.core.util.Resource
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.data.local.WordInfoDao
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.data.remote.DictionaryApi
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.model.WordInfo
import dev.kevalkanpariya.myawesomedictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    val api: DictionaryApi,
    val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word})
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

        } catch ( e:HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = wordInfos
            ))

        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = wordInfos
            ))
        }
        val newwordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newwordInfos))
    }
}