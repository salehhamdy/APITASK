package com.linkdev.apitask.network

import com.linkdev.apitask.network.response.NowPlayingResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {
    // "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1"

    @GET(NetworkConstants.NOW_PLAYING)
    suspend fun getNowPlayingMovies(

        @Query("language") language:String = "en-US",
        @Query("page") page:Int = 1,
        @Header("Authorization") token : String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjOGFmM2RkNjMxNzBlMTQzMTU1YzMyZjRiNmUzYmRkMCIsIm5iZiI6MTcyMTQxNDU2Ni42ODI0NzksInN1YiI6IjY2OWFiMTk4NTNmZGZjODBjMGJmYTg3NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Ba3dBpQ2CzxRknwmuxEoNfnkduRm6mIM2o3Sl49lyao",

        ): Response<NowPlayingResponse>

}