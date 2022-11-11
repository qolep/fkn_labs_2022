package ru.marvel.effectiveLabs.data.network

import android.util.Log
import ru.marvel.effectiveLabs.data.network.model.Result
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.marvel.effectiveLabs.data.models.Resource
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetworkServiceImpl: NetworkService {

    private val apikey = "e426895c827aa56816b990cb4f31ca96"
    private val hash = "bd9d0c04d7096a374e1a0765ec01ef1f"
    private val baseUrl = "https://gateway.marvel.com/"

    private val client = OkHttpClient.Builder()
        .callTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    private val networkService = retrofit.create(ServerApi::class.java)

    override suspend fun getCharacterList(): Resource<List<Result>> {

        return try {
            Resource.Success(
                data = networkService.getHeroesList(apikey, hash, 1).body()!!.data.results
            )
        } catch (e: IOException) {
            Log.e("","$e")
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
    override suspend fun getCharacterInfo(id: Int): Resource<Result> {

        return try {
            Resource.Success(
                data = networkService.getHeroInfo(id = id.toString(), apikey, hash, 1).body()!!.data.results[0]
            )
        } catch (e: IOException) {
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
