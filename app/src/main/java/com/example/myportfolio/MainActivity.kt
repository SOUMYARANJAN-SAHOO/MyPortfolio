package com.example.myportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myportfolio.ui.theme.MyPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPortfolioTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .background(Color.White)
                ) { innerPadding ->
                    HomeScreen(
                        innerPadding
                    )

                }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPaddingValues: PaddingValues) {

    var isCelebrating by remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(innerPaddingValues)){
        Column(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
            ) {
                Image(painter = painterResource(R.drawable.profilepic), contentDescription = "")
            }
            Text(text = "Hii everyone", fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp), fontSize = 20.sp)
            Text(
                text = "This is MD Tanwir Alam.\nI love to work on problems and solve them using modern tech, with an added fist full of creativity.\nI quickly adapt to new insights.\nHappy coding :)",
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .height(40.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(R.drawable.github_1051377),
                    contentDescription = "",
                    modifier = Modifier.padding(8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.linked_12940285),
                    contentDescription = "",
                    modifier = Modifier.padding(8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.social_12940260),
                    contentDescription = "",
                    modifier = Modifier.padding(8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.twitter_11823292),
                    contentDescription = "",
                    modifier = Modifier.padding(8.dp)
                )
            }

            Text(
                text = "My Projects",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
            )

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                item {
                    Box(
                        modifier = Modifier
                            .width(300.dp)
                            .height(200.dp)
                            .padding(8.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(Color.LightGray)
                            .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "My First Project"
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .width(300.dp)
                            .height(200.dp)
                            .padding(8.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(Color.LightGray)
                            .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "My Second Project"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = { isCelebrating = true }, modifier = Modifier
                .fillMaxWidth()
                .padding(innerPaddingValues)) {
                Text(text = "Celebrate")
            }
        }

        if(isCelebrating) LottieConfettiAnimation(onAnimationComplete = {
            isCelebrating = false
        })
    }

}

@Composable
fun LottieConfettiAnimation(onAnimationComplete: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.confetti)) // Replace with your confetti file
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1
    )

    if (progress == 1f) {
        onAnimationComplete()
    }

    LottieAnimation(
        composition = composition,
        progress = { progress },
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Transparent)
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyPortfolioTheme {
        HomeScreen(PaddingValues(16.dp))
    }
}