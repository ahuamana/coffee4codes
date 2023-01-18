package com.paparazziteam.coffee4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.paparazziteam.coffee4coders.ui.components.BodyText
import com.paparazziteam.coffee4coders.ui.components.CountryISO
import com.paparazziteam.coffee4coders.ui.components.ProductCard
import com.paparazziteam.coffee4coders.ui.components.TitleText
import com.paparazziteam.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun FeedScreen(navController: NavController) {

    val list = listOf<CountryISO>(
        CountryISO.COL,
        CountryISO.NIC,
        CountryISO.BRA,
        CountryISO.CRI
    )


    Coffee4CodersTheme() {
        Surface(
            color = MaterialTheme.colors.background) {
            // A surface container using the 'background' color from the theme
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        TitleText(title = "Welcome to Coffee4Coders")
                        BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec aliquet nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, n")
                    }
                }

                items(list) { country->
                    ProductCard(
                        name = country.name,
                        summary = "Café de las Americas",
                        price = 10.0,
                        currency = "USD",
                        countryISO = country){
                        println("Clicked on ${country.name}")
                        navController.navigate("detail"){
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun defaultPreview() {
    val navController = rememberNavController()
    FeedScreen(navController = navController)
}