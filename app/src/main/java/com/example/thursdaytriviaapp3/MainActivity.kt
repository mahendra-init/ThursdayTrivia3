package com.example.thursdaytriviaapp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thursdaytriviaapp3.data.DataSource
import com.example.thursdaytriviaapp3.model.DataModel
import com.example.thursdaytriviaapp3.ui.theme.ThursdayTriviaApp3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThursdayTriviaApp3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = { SearchBar(modifier = Modifier.padding(16.dp)) },
                        content = {
                            RestaurantList(dataModel = DataSource().loadDataModels())
                        })
                }
            }
        }
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var textValue by remember {
        mutableStateOf("")
    }
    TextField(
        value = textValue,
        onValueChange = { onTextChanged ->
            textValue = onTextChanged
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "Search icon"
            )
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        placeholder = { Text(text = stringResource(R.string.hint_search)) },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    )
}


@Composable
fun RestaurantList(dataModel: List<DataModel>, modifier: Modifier = Modifier){
    LazyColumn{
        items(dataModel) {
            item -> RestaurantCard(dataModel = item)  
        }
    }
}

@Composable
fun RestaurantCard(dataModel: DataModel, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(12.dp), elevation = 14.dp) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(
                painter = painterResource(dataModel.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()) {
                Column {
                    Text(
                        text = LocalContext.current.getString(dataModel.titlestringResourceId),
                        style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 28.sp)
                    )
                    Text(
                        text = LocalContext.current.getString(dataModel.menustringResourceId),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.End)
                    .padding(start = 70.dp)) {
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Color.Blue,
                        modifier = Modifier
                            .height(40.dp)
                            .width(70.dp)
                    ) {
                        Row(modifier = Modifier.padding(5.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                            Text(text = "4.1",style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 21.sp), color = Color.White)
                            Image(painter = painterResource(id = R.drawable.star),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(24.dp)
                                    .width(24.dp)
                                    .padding(top = 5.dp),
                                contentScale = ContentScale.Crop
                               )
                        }

                    }
                    Text(
                        text = LocalContext.current.getString(dataModel.ratestringResourceId),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ThursdayTriviaApp3Theme {
        Scaffold(
            topBar = { SearchBar(modifier = Modifier.padding(16.dp)) },
            content = {
                RestaurantList(dataModel = DataSource().loadDataModels())
            })
    }
}

