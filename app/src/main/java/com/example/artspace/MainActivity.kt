package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}

@Composable
fun ArtSpaceLayout() {

    var imageState by remember { mutableStateOf(R.drawable.starry_night) }
    var titleState by remember { mutableStateOf(R.string.starry_title) }
    var artistState by remember { mutableStateOf(R.string.starry_artist) }
    var yearState by remember { mutableStateOf(R.string.starry_year) }
    var currentArt by remember { mutableStateOf(1) }

    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(40.dp)
        ) {
            Surface(
                modifier = Modifier
                    .padding(32.dp),
                color = Color.White,
                shadowElevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(imageState),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(25.dp)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 40.dp)
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 32.dp, top = 16.dp, bottom = 16.dp, end = 110.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(titleState),
                        fontSize = 24.sp
                    )
                    Row {
                        Text(
                            text = stringResource(artistState),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(yearState),
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        when (currentArt) {
                            1 -> {
                                imageState = R.drawable.the_scream
                                titleState = R.string.the_scream_title
                                artistState = R.string.the_scream_artist
                                yearState = R.string.the_scream_year
                                currentArt = 3
                            }

                            2 -> {
                                imageState = R.drawable.starry_night
                                titleState = R.string.starry_title
                                artistState = R.string.starry_artist
                                yearState = R.string.starry_year
                                currentArt = 1
                            }

                            3 -> {
                                imageState = R.drawable.monalisa
                                titleState = R.string.mona_lisa_title
                                artistState = R.string.mona_lisa_artist
                                yearState = R.string.mona_lisa_year
                                currentArt = 2
                            }

                        }
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    modifier = Modifier
                        .size(width = 130.dp, height = 35.dp)
                ) {
                    Text(
                        text = "Previous"
                    )
                }
                Button(
                    onClick = {
                        when (currentArt) {
                            1 -> {
                                imageState = R.drawable.monalisa
                                titleState = R.string.mona_lisa_title
                                artistState = R.string.mona_lisa_artist
                                yearState = R.string.mona_lisa_year
                                currentArt = 2
                            }

                            2 -> {
                                imageState = R.drawable.the_scream
                                titleState = R.string.the_scream_title
                                artistState = R.string.the_scream_artist
                                yearState = R.string.the_scream_year
                                currentArt = 3
                            }

                            3 -> {
                                imageState = R.drawable.starry_night
                                titleState = R.string.starry_title
                                artistState = R.string.starry_artist
                                yearState = R.string.starry_year
                                currentArt = 1
                            }

                        }
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    modifier = Modifier
                        .size(width = 130.dp, height = 35.dp)
                ) {
                    Text(
                        text = "Next"
                    )
                }
            }
        }
    }

}

