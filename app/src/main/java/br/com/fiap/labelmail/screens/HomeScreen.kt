package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.labelmail.R
import br.com.fiap.labelmail.model.Button
import br.com.fiap.labelmail.model.MenuItem
import br.com.fiap.labelmail.model.SimpleButton
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Content() {
    val buttonsScrollState = rememberScrollState()


    val buttons = listOf(
        Button("Todos", R.drawable.grid, Color(0x2066D563), Color(0xFF66D563)),
        Button("Educação", R.drawable.book_open, Color(0x20F44B4B), Color(0xFFF44B4B)),
        Button("Família", R.drawable.home, Color(0x20F4884B), Color(0xFFF4884B)),
        Button("Importante", R.drawable.alert_circle, Color(0x20EDC254), Color(0xFFEDC254)),
        Button("Propaganda", R.drawable.gift, Color(0x20B44BF4), Color(0xFFB44BF4)),
        Button("Social", R.drawable.users, Color(0x204BA3F4), Color(0xFF4BA3F4))
    )

    val simpleButtons = listOf(
        SimpleButton("Educação", Color(0x20F44B4B), Color(0xFFF44B4B)),
        SimpleButton("Família", Color(0x20F4884B), Color(0xFFF4884B)),
        SimpleButton("Importante", Color(0x20EDC254), Color(0xFFEDC254)),
        SimpleButton("Propaganda", Color(0x20B44BF4), Color(0xFFB44BF4)),
        SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(buttonsScrollState)
                .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
        ) {
            buttons.forEachIndexed { index, button ->
                ElevatedButton(
                    onClick = { println(button.label) },
                    modifier = Modifier.padding(end = if (index == buttons.size - 1) 24.dp else 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = button.containerColor),
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
                        painter = painterResource(id = button.iconId),
                        tint = button.tintColor,
                        contentDescription = button.label
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(button.label, color = button.tintColor, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Row(
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
                ) {
                    Column(
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = "User Icon",
                            modifier = Modifier
                                .clip(CircleShape)
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Row(
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Column {
                                Text(
                                    text = "GitHub Education",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "Hey! We're back with an action-packed...",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                            Column {
                                Text(
                                    text = "15:01",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            simpleButtons.forEach { button ->
                                ElevatedButton(
                                    onClick = { println(button.label) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = button.containerColor,
                                        disabledContainerColor = button.containerColor
                                    ),
                                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    contentPadding = PaddingValues(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 8.dp,
                                        bottom = 8.dp
                                    ),
                                    enabled = false
                                ) {
                                    Text(
                                        button.label,
                                        color = button.tintColor,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }


                }
            }

            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DrawerContent(onClose: () -> Unit, navController: NavHostController) {
    val menuItems = listOf(
        MenuItem("Enviados", R.drawable.send, "enviados"),
        MenuItem("Rascunhos", R.drawable.file, "rascunhos"),
        MenuItem("Excluídos", R.drawable.trash, "excluidos"),
        MenuItem("Lixo Eletrônico", R.drawable.alert_circle, "lixo-eletronico"),
        MenuItem("Calendário", R.drawable.calendar, "calendario")
    )

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
                menuItems.forEach { menuItem ->
                    IconButton(
                        onClick = { navController.navigate(menuItem.route) },
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = menuItem.iconId),
                                    contentDescription = menuItem.title
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = menuItem.title, fontSize = 16.sp)
                            }
                        }
                    )
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