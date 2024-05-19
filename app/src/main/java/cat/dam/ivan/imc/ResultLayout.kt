package cat.dam.ivan.imc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ResultLayout(nav: NavController ,altura: String?, peso: String?) {
    val alturaFloat = altura?.toFloat() ?: 5f
    val pesoFloat = peso?.toFloat() ?: 5f

    val imcResultat = pesoFloat / (alturaFloat * alturaFloat)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .padding(0.dp, 25.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Row {
                Text(
                    text = altura ?: "5",
                    fontWeight = FontWeight.Bold
                )
                Icon(painter = painterResource(id = R.drawable.height_24px) , contentDescription ="altura")
            }

            Row {
                Text(
                    text = peso ?: "5",
                    fontWeight = FontWeight.Bold
                )
                Icon(painter = painterResource(id = R.drawable.weight_24px) , contentDescription ="pes")
            }
        }
        Row(
            modifier = Modifier
                .padding(0.dp, 25.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "IMC: $imcResultat",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        ObesityTable()

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .padding(0.dp, 25.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            obesityBar(imcResultat)
        }

        Button(onClick = { nav.navigate("MainLayout") }) {
            Text(text = "Calcular de nou")
        }
    }
}

@Composable
fun ObesityTable() {
    Column(
        modifier = Modifier
            .padding(25.dp, 0.dp, 25.dp, 0.dp)
            .fillMaxWidth()
    ) {
        Row(Modifier.fillMaxWidth()) {
            Text(text = "IMC Range", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(text = "Category", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "0.0 - 18.5", modifier = Modifier.weight(1f))
            Text(text = "Low weight", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFFFC15F)),
            )
        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "18.5 - 24.9", modifier = Modifier.weight(1f))
            Text(text = "Normal weight", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFF557102)),

            )
        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "25.0 - 26.9", modifier = Modifier.weight(1f))
            Text(text = "Overweight", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFFFC15F)),
            )


        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "27.0 - 29.9", modifier = Modifier.weight(1f))
            Text(text = "Pre-obesity", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFFCA044)),
            )

        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "30.0 - 34.9", modifier = Modifier.weight(1f))
            Text(text = "Obesity class 1", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFF37736)),
            )
        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "35.0 - 39.9", modifier = Modifier.weight(1f))
            Text(text = "Obesity class 2", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFE13C32)),
            )
        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "40.0 - 49.9", modifier = Modifier.weight(1f))
            Text(text = "Obesity class 3", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFFC30032)),
            )

        }
        Row(Modifier.fillMaxWidth()) {
            Text(text = "50.0 - MAX", modifier = Modifier.weight(1f))
            Text(text = "Extreme obesity", modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .width(30.dp)
                .height(25.dp)
                .background(Color(0xFF71021E)),
            )
        }
    }
}

@Composable
fun obesityBar(resultatIMC : Float){
    var imcCategory = ""
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)){
        imcCategory = when(resultatIMC) {
            in 0.0..18.5 -> "Low weight"
            in 18.5..24.9 -> "Normal weight"
            in 25.0..26.9-> "Overweight"
            in 27.0..29.9 -> "Pre-obesity"
            in 30.0..34.9 -> "Obesity class 1"
            in 35.0..39.9 -> "Obesity class 2"
            in 40.0..49.9 -> "Obesity class 3"
            in 50.0..Double.MAX_VALUE -> "Extreme obesity"
            else -> "Error"
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFFFC15F)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Low weight") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFF557102)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Normal weight") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFFFC15F)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Overweight") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFFCA044)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Pre-obesity") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFF37736)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Obesity class 1") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFE13C32)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Obesity class 2") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFFC30032)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Obesity class 3") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
        Box(modifier = Modifier
            .width(30.dp)
            .height(25.dp)
            .background(Color(0xFF71021E)),
            contentAlignment = Alignment.Center
        ){
            if (imcCategory == "Extreme obesity") {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "IMC Icon", Modifier.offset(0.dp, 20.dp))
            }
        }
    }
    Text(text = imcCategory)
}