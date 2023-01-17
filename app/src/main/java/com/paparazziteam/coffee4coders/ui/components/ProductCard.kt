package com.paparazziteam.coffee4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paparazziteam.coffee4coders.R
import com.paparazziteam.coffee4coders.ui.theme.Coffee4CodersTheme
import com.paparazziteam.coffee4coders.ui.theme.PlatziBlue
import com.paparazziteam.coffee4coders.ui.theme.PlatziGreen
import java.util.Currency

@Composable
fun ProductCard(name:String,
                summary:String,
                price:Double,
                currency: String,
                countryISO: CountryISO,
                onClick:()->Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small // RoundedCornerShape(4.dp)
    ) {
        Image(painter = painterResource(id = countryISO.getDrawable()),
            contentDescription = "Coffee")

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = countryISO.getSurfaceColor().copy(alpha = 0.2f)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = name,
                    style = MaterialTheme.typography.h4,)
                Text(text = summary,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center)
                
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Image(painter = painterResource(id = countryISO.getCountryFlag()),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                        )
                        Text(text = "Price: $ $price $currency",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    Coffee4CodersTheme() {
        ProductCard(
            name = "Coffee",
            summary = "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried. Dried coffee seeds (referred to as beans) are roasted to varying degrees, depending on the desired flavor.",
            price = 2.5,
            currency = "USD",
            countryISO = CountryISO.BRA,
        ){

        }
    }
}

enum class CountryISO(val iso: String) {
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getDrawable(): Int {
        return when (this) {
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.ri
            NIC -> R.drawable.ni
        }
    }

    fun getCountryFlag(): Int {
        return when (this) {
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }

    fun getSurfaceColor(): Color {
        return when (this) {
            COL, NIC -> PlatziBlue
            BRA, CRI -> PlatziGreen
        }
    }
}
