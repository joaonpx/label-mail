package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.CalendarContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.labelmail.R
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CalendarioScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("") },
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        content = {
            CalendarioContent(navController)
        }
    )
}

@Composable
fun CalendarioContent(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Text(text = "Calendário", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)

        CategoryCheckboxList()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Aplica o espaço entre os elementos na linha
        ) {
            TextButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = CalendarContract.CONTENT_URI.buildUpon().appendPath("time").build()
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                },
            ) {
                Text("Salvar", color = Color(0xFF8EB129))
            }
            TextButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = CalendarContract.CONTENT_URI.buildUpon().appendPath("time").build()
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                },
            ) {
                Text("Abrir Calendário", color = Color(0xFF0c0c0c))
            }
        }
    }
}

@Composable
fun CategoryCheckboxList() {
    val categories = listOf(
        "Todas" to Color(0xFF66D563),
        "Educação" to Color(0xFFF44B4B),
        "Família" to Color(0xFFF4884B),
        "Importante" to Color(0xFFEDC254),
        "Propaganda" to Color(0xFFB44BF4),
        "Social" to Color(0xFF4BA3F4)
    )

    val checkedState = remember { mutableStateListOf(*Array(categories.size) { false }) }

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Checkbox(
                    checked = checkedState[index],
                    onCheckedChange = { checked ->
                        // Atualiza o estado do checkbox atual
                        checkedState[index] = checked

                        // Se o checkbox "Todas" for marcado ou desmarcado, atualiza todos os outros
                        if (index == 0) {
                            for (i in 1 until checkedState.size) {
                                checkedState[i] = checked
                            }
                        } else {
                            // Se qualquer checkbox individual for desmarcado, desmarque o checkbox "Todas"
                            if (!checked) {
                                checkedState[0] = false
                            } else {
                                // Se todos os checkboxes (exceto "Todas") forem marcados, marque "Todas"
                                val allChecked = checkedState.drop(1).all { it }
                                if (allChecked) {
                                    checkedState[0] = true
                                }
                            }
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = category.second,
                        uncheckedColor = category.second
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = category.first, fontSize = 16.sp)
            }
        }
    }
}
