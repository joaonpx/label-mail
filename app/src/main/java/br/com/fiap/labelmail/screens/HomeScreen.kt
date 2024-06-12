package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun HomeScreen(navController: NavHostController) {
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
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_menu_24),
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(onClose = {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }, navController)
        },
        content = {
            Content()
        }
    )
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column {
            ElevatedButton(
                onClick = { println("Todos") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x2066D563)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.grid),
                    tint = Color(0xFF66D563),
                    contentDescription = "Todos"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Todos", color = Color(0xFF66D563), fontWeight = FontWeight.SemiBold)
            }
            ElevatedButton(
                onClick = { println("Educação") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20F44B4B)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.book_open),
                    tint = Color(0xFFF44B4B),
                    contentDescription = "Educação"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Educação", color = Color(0xFFF44B4B), fontWeight = FontWeight.SemiBold)
            }
            ElevatedButton(
                onClick = { println("Família") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20F4884B)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    tint = Color(0xFFF4884B),
                    contentDescription = "Família"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Família", color = Color(0xFFF4884B), fontWeight = FontWeight.SemiBold)
            }
            ElevatedButton(
                onClick = { println("Importante") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20EDC254)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.alert_circle),
                    tint = Color(0xFFEDC254),
                    contentDescription = "Importante"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Importante", color = Color(0xFFEDC254), fontWeight = FontWeight.SemiBold)
            }
            ElevatedButton(
                onClick = { println("Propaganda") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20B44BF4)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.gift),
                    tint = Color(0xFFB44BF4),
                    contentDescription = "Propaganda"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Propaganda", color = Color(0xFFB44BF4), fontWeight = FontWeight.SemiBold)
            }
            ElevatedButton(
                onClick = { println("Social") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x204BA3F4)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.users),
                    tint = Color(0xFF4BA3F4),
                    contentDescription = "Social"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Social", color = Color(0xFF4BA3F4), fontWeight = FontWeight.SemiBold)
            }
        }

        Column {
            ElevatedButton(
                onClick = { println("Educação") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20F44B4B)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text("Educação", color = Color(0xFFF44B4B), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
            ElevatedButton(
                onClick = { println("Família") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20F4884B)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text("Família", color = Color(0xFFF4884B), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
            ElevatedButton(
                onClick = { println("Importante") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20EDC254)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text("Importante", color = Color(0xFFEDC254), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
            ElevatedButton(
                onClick = { println("Propaganda") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x20B44BF4)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text("Propaganda", color = Color(0xFFB44BF4), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
            ElevatedButton(
                onClick = { println("Social") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x204BA3F4)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text("Social", color = Color(0xFF4BA3F4), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun DrawerContent(onClose: () -> Unit, navController: NavHostController) {
    Column(
//        modifier = Modifier.fillMaxSize().padding(18.dp),
    ) {
        IconButton(onClick = onClose) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "Close"
            )
        }

        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        ) {
            Text(text = "Menu", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)

            Column {
                IconButton(onClick = onClose) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Caixa de Entrada", fontSize = 16.sp)
                    }

                }

                IconButton(onClick = { navController.navigate("enviados") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Enviados"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Enviados", fontSize = 16.sp)
                    }
                }

                IconButton(onClick = { navController.navigate("rascunhos") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.file),
                            contentDescription = "Rascunhos"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Rascunhos", fontSize = 16.sp)
                    }
                }

                IconButton(onClick = { navController.navigate("excluidos") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.trash),
                            contentDescription = "Excluídos"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Excluídos", fontSize = 16.sp)
                    }
                }

                IconButton(onClick = { navController.navigate("lixo-eletronico") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.alert_circle),
                            contentDescription = "Lixo Eletronico"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Lixo Eletronico", fontSize = 16.sp)
                    }
                }

                IconButton(onClick = { navController.navigate("calendario") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.calendar),
                            contentDescription = "Calendário"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Calendário", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}