package com.example.chatbot.on_board.presentation.on_board_screen

import android.annotation.SuppressLint
import android.graphics.Matrix
import android.graphics.RectF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Fill
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser
import com.example.chatbot.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

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
            Image(painter = painterResource(R.drawable.black_background),contentDescription = null, contentScale = ContentScale.Crop,modifier = Modifier.fillMaxSize())
            foreground(viewModel,onRegister)
        }

    }
    @Composable
    override fun FeaturesCarousel(modifier: Modifier, onItemChanges: (Int) -> Unit) {
        //cauta LazyRow care va contine toate acele carduri cu imagini
        val state = rememberLazyListState()
        LazyRow(state = state) {
                items(Feature.list,key = {it.imageId})
                {
                    FeatureCard(modifier = Modifier.fillParentMaxWidth() ,it)
                }
        }
        LaunchedEffect(key1 = state.firstVisibleItemIndex )
        {
            onItemChanges(state.firstVisibleItemIndex)
        }



    }
    @Composable
    fun FeatureCard(modifier: Modifier, feature: Feature) {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)

        ) {
            Column(modifier = Modifier.padding(16.dp)){
                Image(painter = painterResource(feature.imageId), contentDescription = null)
                Text(
                    text = stringResource(feature.titleId),
                    color = Color.White, // Set the text color to white
                    fontSize = 20.sp, // Set the font size for the title
                    fontWeight = FontWeight.Bold // Optionally, set the font weight for the title
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = stringResource(feature.bodyId),
                    color = Color.White, // Set the text color to white
                    fontSize = 16.sp // Set the font size for the body
                )

            }
        }
    }



    @Composable
    fun ItemSlider(
        modifier: Modifier,
        currentItem: Flow<Int>,
        numberOfItems: Int,
        currentItemContent: @Composable () -> Unit = {
            Surface(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .width(15.dp)
                    .height(10.dp),
                color = Color.Green
            ) {}
        },
        defaultItemContent: @Composable () -> Unit = {
            Surface(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp),
                color = MaterialTheme.colorScheme.surface
            ) {}
        },
        verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
        horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp),
        textSpacerHeight: Dp = 20.dp
    ) {
        val currentState by currentItem.collectAsState(initial = 0)
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(numberOfItems) {
                if (it > 0) {
                    Spacer(modifier = Modifier.width(10.dp)) // Spațiu între buline
                }
                if (it == currentState) {
                    currentItemContent()
                } else {
                    Spacer(modifier = Modifier.height(textSpacerHeight)) // Spațiu între text și bulă
                    defaultItemContent()
                }
            }
        }
    }



    @Composable fun foreground(viewModel: OnBoardViewModel, onRegister: () -> Unit){

        val currentItem = MutableStateFlow(0)
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FeaturesCarousel (modifier= Modifier
                .fillMaxWidth()
                .wrapContentHeight(),onItemChanges = {
                scope.launch{currentItem.emit(it)}

            })
            ItemSlider(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                currentItem = currentItem,
                numberOfItems = 3 ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            )
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



