package br.com.fiap.labelmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.labelmail.screens.CalendarioScreen
import br.com.fiap.labelmail.screens.EnviadosScreen
import br.com.fiap.labelmail.screens.ExcluidosScreen
import br.com.fiap.labelmail.screens.HomeScreen
import br.com.fiap.labelmail.screens.LixoEletronicoScreen
import br.com.fiap.labelmail.screens.RascunhosScreen
import br.com.fiap.labelmail.ui.theme.LabelMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabelMailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFDFEFA)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable(route = "home") { HomeScreen(navController) }
                        composable(route = "enviados") { EnviadosScreen(navController) }
                        composable(route = "rascunhos") { RascunhosScreen(navController) }
                        composable(route = "excluidos") { ExcluidosScreen(navController) }
                        composable(route = "lixo-eletronico") { LixoEletronicoScreen(navController) }
                        composable(route = "calendario") { CalendarioScreen(navController) }
                    }
                }
            }
        }
    }
}