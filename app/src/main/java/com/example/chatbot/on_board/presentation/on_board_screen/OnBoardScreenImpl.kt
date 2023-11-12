package com.example.chatbot.on_board.presentation.on_board_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.chatbot.R

object OnBoardScreenImpl: OnBoardScreen() {
    class Feature (val imageId: Int , val titleId:Int, val bodyId: Int)
    {
        companion object{
            val list = listOf(Feature(R.drawable.poza1,R.string.onboard_feature1_title,R.string.onboard_feature1_body),,Feature(R.drawable.poza2,R.string.onboard_feature2_title,R.string.onboard_feature2_body),Feature(R.drawable.poza3,R.string.onboard_feature3_title,R.string.onboard_feature3_body))
        }
    }
    @Composable
    override fun Main(viewModel: OnBoardViewModel, onRegister: () -> Unit) {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(painter = painterResource(R.drawable.on_board_background),contentDescription = null)
            foreground(viewModel,onRegister)
        }
        TODO("Not yet implemented")
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

        TODO("Not yet implemented")
    }
    @Composable fun FeatureCard(feature : Feature)
    {
//To do
    }
    @Composable fun foreground(viewModel: OnBoardViewModel, onRegister: () -> Unit){
//To do
    }

    @Composable
    override fun RegisterButton(modifier: Modifier, onClick: () -> Unit) {
        TODO("Not yet implemented")
    }
}