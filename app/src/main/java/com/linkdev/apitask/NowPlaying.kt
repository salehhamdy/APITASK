package com.linkdev.apitask

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.linkdev.apitask.network.RetrofitBuilder
import com.linkdev.apitask.network.response.NowPlayingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NowPlaying(modifier: Modifier = Modifier) {
    var nowPlayingState: NowPlayingResponse? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(key1 = Unit) {
        launch(Dispatchers.IO) {
            delay(3000)
            try {
                nowPlayingState = RetrofitBuilder.getAPIService().getNowPlayingMovies().body()

            } catch (e: Exception) {

            }
        }
    }

    LazyColumn(modifier = modifier) {
        items(nowPlayingState?.results ?: emptyList()) { movie ->

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 4.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .border(BorderStroke(1.dp, color = Color.Black), RoundedCornerShape(8.dp))

                ) {
                    GlideImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(200.dp)
                            .height(250.dp),
                        model = movie.posterPath.fullImageURL(),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        text = movie.title ?: "MOVIET-TITLE",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        text = movie.overview ?: "MOVIET-overview",
                        color = Color.Black,
                        textAlign = TextAlign.Center

                    )

                }
            }
        }
    }

