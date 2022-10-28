package com.joel.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.movie.data.repository.MainViewModel
import com.joel.movie.ui.theme.YellowVariant
import com.joel.movie.ui.theme.YellowishColor

@Composable
fun SearchAction(
    mainViewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){


    val query: MutableState<String> = remember { mutableStateOf("") }
    val result = mainViewModel.list.value

    OutlinedTextField(
        value = query.value,
        onValueChange = {
           query.value = it
            mainViewModel.searchItem(query.value)
        },
        placeholder = {
            Row(
                modifier = Modifier.padding(1.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primaryVariant
                )
               Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Search...",
                    color = Color.LightGray
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            backgroundColor = Color.White,
            textColor = Color.Black
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                ImeAction.Search
            }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        singleLine = true
    )

}

@Preview(showBackground = true)
@Composable
fun SearchPreview(){
    SearchAction()
}