package com.example.composedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.composedesign.components.cards.CardCity
import com.example.composedesign.components.cards.CardHotel
import com.example.composedesign.models.City
import com.example.composedesign.models.Hotel
import com.example.composedesign.navigation.NavigationItem
import com.example.composedesign.ui.theme.ComposeDesignTheme
import com.example.composedesign.ui.theme.black
import com.example.composedesign.ui.theme.green
import com.example.composedesign.ui.theme.placeholder
import com.example.composedesign.utils.DataDummy
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = black.copy(alpha = 0.4f)
            )

            ComposeDesignTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController) }
                ) {
                    Navigation(navController)
                }
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Header()
        TitleHeader()
        HorizontalCity()
        MainContent()
    }
}

@Composable
fun WhistListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Whistlist View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Chat View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@ExperimentalCoilApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.WhistList.route) {
            WhistListScreen()
        }
        composable(NavigationItem.Chat.route) {
            ChatScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.WhistList,
        NavigationItem.Chat
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.White
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.route
                    )
                },
                label = {
                    Column() {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            item.title,
                            modifier = Modifier.padding(top = 12.dp),
                            style = MaterialTheme.typography.subtitle1.copy(
                                color = if (currentRoute == item.route) green else placeholder,
                                fontSize = 12.sp,
                            ),
                        )
                    }
                },
                selectedContentColor = green,
                unselectedContentColor = placeholder,
                alwaysShowLabel = true
            )
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun BottomNavigationBarPreview() {
//    ComposeDesignTheme() {
//        BottomNavigationBar()
//    }
//}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Notifications,
                contentDescription = "Notification Icon",
                tint = MaterialTheme.colors.onBackground,
            )
        }

        Surface(
            modifier = Modifier
                .padding(end = 12.dp)
                .width(42.dp)
                .height(42.dp),
            color = MaterialTheme.colors.onBackground,
            shape = RoundedCornerShape(50),
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
        }

    }
}

@Composable
fun TitleHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 12.dp, end = 12.dp, top = 22.dp,
            )
    ) {
        Text(
            text = "Cari Tempat tinggal?",
            style = MaterialTheme.typography.h1
        )
        Text(
            text = "Dapatkan Informasinya disini",
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(top = 8.dp)
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            color = MaterialTheme.colors.secondary,
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = "Cari apartment ?",
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
                style = MaterialTheme.typography.body1,
                fontSize = 12.sp
            )
        }
    }
}


@ExperimentalCoilApi
@Composable
fun HorizontalCity() {
    val city: List<City> = DataDummy.generateCityList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 12.dp, end = 12.dp, top = 22.dp,
            )
    ) {
        Text(
            text = "Kota terdekat",
            style = MaterialTheme.typography.h2
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            city.forEach { item ->
                CardCity(title = item.title, restCount = item.count, url = item.url)
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun MainContent() {
    val hotel: List<Hotel> = DataDummy.generateHotel()
    Column(modifier = Modifier.padding(top = 24.dp, start = 12.dp, end = 12.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tempat Tinggal terdekat",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "See all",
                color = green,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        hotel.forEach { item ->
            CardHotel(
                title = item.title,
                location = item.location,
                price = item.price,
                url = item.url
            )
        }
        Spacer(modifier = Modifier.height(120.dp))
    }
}


//@ExperimentalCoilApi
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeDesignTheme {
//        Scaffold(
//            bottomBar = { BottomNavigationBar({}) }
//        ) { innerPadding ->
//            Column(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .verticalScroll(rememberScrollState()),
//            ) {
//                Header()
//                TitleHeader()
//                HorizontalCity()
//                MainContent()
//            }
//        }
//    }
//}