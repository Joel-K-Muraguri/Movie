package com.joel.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.joel.movie.R
import com.joel.movie.navigation.BottomNav

@Composable
fun TopSection(){

   Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically,
       modifier = Modifier
           .fillMaxWidth()
           .padding(12.dp)
   ) {
       MenuItem()
       User()
   }



}

@Composable
fun MenuItem(){

    Box(
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .align(Alignment.TopStart),
            shape = CircleShape
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "",
                tint = Color.Black
            )
        }
    }

}

@Composable
fun User(){

    Box(
        contentAlignment = Alignment.Center,

    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.TopEnd),
            shape = CircleShape

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                modifier = Modifier
                    .size(35.dp)
                    .fillMaxSize(),
                contentDescription = "",
                tint = Color.Black

            )
        }
    }

}

@Preview
@Composable
fun TopSectionPreview(){
    TopSection()
}