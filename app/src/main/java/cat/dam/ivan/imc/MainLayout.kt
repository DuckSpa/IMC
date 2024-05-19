package cat.dam.ivan.imc


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainLayout(navController: NavController) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(25.dp))

        Text(
            modifier = Modifier.padding(55.dp, 0.dp, 55.dp, 0.dp),
            text = "Calculadora de IMC",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.size(25.dp))

        val altura = customTextField(lbl = "altura", icon = R.drawable.height_24px)

        println(altura)

        Spacer(modifier = Modifier.size(25.dp))

        val peso = customTextField(lbl = "pes", icon = R.drawable.weight_24px)

        println(peso)

        Spacer(modifier = Modifier.size(25.dp))

        ElevatedButton(
            modifier = Modifier.size(275.dp, 55.dp),
            shape = MaterialTheme.shapes.extraLarge,
            onClick = { navController.navigate("ResultLayout/altura=${altura}&peso=${peso}") }

        ) {
            Text(
                text = "Calcular",
                fontSize = 15.sp
            )
        }
    }
}