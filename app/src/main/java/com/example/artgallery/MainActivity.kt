package com.example.artgallery

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtGallery()
                }
            }
        }
    }
}

@Composable
fun ArtGallery() {
    var count by remember { mutableStateOf(1)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(count){
            0->{count = 10
            }
            1->{ArtGalleryFrame(R.drawable.god_lord_krishna_wallpaper_preview,R.string.God_krishna,R.string.krishna)
            }
            2->{ArtGalleryFrame(R.drawable.harley_davidson_hd_wallpaper_free_download,R.string.harley_davidson,R.string.harley)
            }
            3->{ArtGalleryFrame(R.drawable.bfdaee6919733ae01b9036f888165cc7,R.string.jungle_king,R.string.manish)
            }
            4->{ArtGalleryFrame(R.drawable.car_wallpapers_hd_mercedes,R.string.mercedes_car,R.string.mercedes)
            }
            5->{ArtGalleryFrame(R.drawable.bike_harley_davidson_wallpaper_hd,R.string.harley_davidson,R.string.harley)
            }
            6->{ArtGalleryFrame(R.drawable.desktop_wallpaper_hd_widescreen_free_download_1366x768_14,R.string.white_Flower,R.string.swarnali_das)
            }
            7->{ArtGalleryFrame(R.drawable.itl_cat_live_wallpaper_hd_105271,R.string.goa_beach,R.string.saket)
            }
            8->{ArtGalleryFrame(R.drawable.illuminati_gold_on_black_background_czpn60m9e9c9n7b2,R.string.illuminati_gold,R.string.illuminati)
            }
            9->{
                ArtGalleryFrame(R.drawable.kriti_sanon_in_pastel_pink_strapless_gown_deepika_padukone_ranveer_singh_reception,R.string.kriti,R.string.Sanon)
            }
            10->{
                ArtGalleryFrame(R.drawable.best_hd_wallpapers_16,R.string.pirates,R.string.Johnny_Depp)
            }
            else->{
                    count = 1
            }
        }
//        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {
            Button(onClick = { count--
            Log.e("onPrevious","onPreviousClick")
            }
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { count++
                Log.e("onNext","onNextClick")
            }
            ) {

                Text(text = "Next")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtGalleryPreview() {
    ArtGalleryTheme {
        ArtGallery()
    }
}






@Composable
fun ArtGalleryFrame(imageId :Int, imageDescriptionId : Int, photographerId:Int){
    Column(modifier = Modifier
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier.border(2.dp, Color.Blue, RoundedCornerShape(20.dp))
            .padding(20.dp)
        ){
            Image(
                painterResource(imageId) ,
                contentDescription = stringResource(imageDescriptionId),
                modifier = Modifier.clip(RoundedCornerShape(10.dp))

            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier.border(2.dp, Color.Blue, RoundedCornerShape(10.dp))
        ){
            Column( modifier = Modifier.padding(15.dp)
            ){
                Text(text = stringResource(imageDescriptionId),
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Text(text = stringResource(photographerId),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
            }

        }

    }
}

@Preview
@Composable
fun ArtGalleryFramePreview(){
    ArtGalleryFrame(R.drawable.kriti_sanon_in_pastel_pink_strapless_gown_deepika_padukone_ranveer_singh_reception,R.string.kriti,R.string.Sanon)

}