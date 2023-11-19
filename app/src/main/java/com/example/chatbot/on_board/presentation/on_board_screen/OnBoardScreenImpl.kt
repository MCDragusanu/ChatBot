package com.example.chatbot.on_board.presentation.on_board_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chatbot.R

object OnBoardScreenImpl: OnBoardScreen() {
    class Feature (val imageId: Int , val titleId:Int, val bodyId: Int)
    {
        companion object{
            val list = listOf(Feature(R.drawable.poza1,R.string.onboard_feature1_title,R.string.onboard_feature1_body),
                Feature(R.drawable.poza2,R.string.onboard_feature2_title,R.string.onboard_feature2_body),
                Feature(R.drawable.poza3,R.string.onboard_feature3_title,R.string.onboard_feature3_body))
        }
    }
    @Composable
    override fun Main(viewModel: OnBoardViewModel, onRegister: () -> Unit) {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(painter = painterResource(R.drawable.on_board_background),contentDescription = null)
            foreground(viewModel,onRegister)
        }

    }
    @Composable
    override fun FeaturesCarousel(modifier: Modifier, onItemChanges: (Int) -> Unit) {
        //cauta LazyRow care va contine toate acele carduri cu imagini

        LazyRow(){
                items(Feature.list,key = {it.imageId})
                {
                    FeatureCard(it)
                }
        }


    }
    @Composable fun FeatureCard(feature : Feature)
    {

        Card { Image(painter = painterResource(feature.imageId),contentDescription = null)
            Text(text = stringResource(feature.titleId))
            Text(text = stringResource(feature.bodyId))
        }

    }
    @Composable fun foreground(viewModel: OnBoardViewModel, onRegister: () -> Unit){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FeaturesCarousel (modifier= Modifier.fillMaxWidth().wrapContentHeight(),onItemChanges = {})
            RegisterButton(
                modifier = Modifier.padding(16.dp),
                onClick = onRegister
            )
        }
    }

    @Composable
    override fun RegisterButton(modifier: Modifier, onClick: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = onClick
            )
                    {
                        Text(text = "Register Now")
                    }
        }
    }
}