package cat.dam.ivan.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import cat.dam.ivan.imc.ui.theme.IMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val currentRoute = remember { mutableStateOf("MainLayout") }

            val navGraph = remember(navController) {
                navController.createGraph(startDestination = currentRoute.value) {
                    composable("MainLayout") { MainLayout(navController) }
                    composable("ResultLayout/altura={altura}&peso={peso}") { backStackEntry ->
                            val altura = backStackEntry.arguments?.getString("altura")
                            val peso = backStackEntry.arguments?.getString("peso")
                        ResultLayout(navController ,altura = altura, peso = peso)
                    }
                }
            }
            IMCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, navGraph)
                }
            }
        }
    }
}