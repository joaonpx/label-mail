package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.labelmail.R
import br.com.fiap.labelmail.model.Button
import br.com.fiap.labelmail.model.EmailData
import br.com.fiap.labelmail.model.MenuItem
import br.com.fiap.labelmail.model.SimpleButton
import kotlinx.coroutines.launch

val emails = listOf(
    EmailData(
        title = "GitHub Education",
        description = "Estamos de volta com um conteúdo cheio de ação...",
        time = "15:01",
        categories = listOf(
            SimpleButton("Educação", Color(0x20F44B4B), Color(0xFFF44B4B)),
            SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4))
        ),
        userInitial = "G",
        category = "Educação"
    ),
    EmailData(
        title = "Microsoft Teams",
        description = "Não se esqueça da sua reunião amanhã.",
        time = "14:30",
        categories = listOf(
            SimpleButton("Importante", Color(0x20EDC254), Color(0xFFEDC254)),
            SimpleButton("Trabalho", Color(0x204BA3F4), Color(0xFF4BA3F4))
        ),
        userInitial = "M",
        category = "Importante"
    ),
    EmailData(
        title = "Henry Walker",
        description = "Ansioso para ver todos no nosso encontro de família.",
        time = "12:00",
        categories = listOf(
            SimpleButton("Família", Color(0x20F4884B), Color(0xFFF4884B)),
            SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4))
        ),
        userInitial = "H",
        category = "Família"
    ),
    EmailData(
        title = "RH",
        description = "Parabéns! Você foi promovido a Desenvolvedor Sênior",
        time = "09:45",
        categories = listOf(
            SimpleButton("Trabalho", Color(0x20F44B4B), Color(0xFFF44B4B)),
            SimpleButton("Importante", Color(0x20EDC254), Color(0xFFEDC254))
        ),
        userInitial = "R",
        category = "Trabalho"
    ),
    EmailData(
        title = "Instagram",
        description = "Você tem novas notificações",
        time = "08:20",
        categories = listOf(
            SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4)),
            SimpleButton("Notificação", Color(0x20B44BF4), Color(0xFFB44BF4))
        ),
        userInitial = "I",
        category = "Social"
    ),
    EmailData(
        title = "Isabella Young",
        description = "Nova tarefa atribuída. Por favor, revise e forneça feedback o mais rápido possível.",
        time = "12/06",
        categories = listOf(
            SimpleButton("Trabalho", Color(0x20F44B4B), Color(0xFFF44B4B)),
            SimpleButton("Importante", Color(0x20EDC254), Color(0xFFEDC254))
        ),
        userInitial = "I",
        category = "Trabalho"
    ),
    EmailData(
        title = "Trivago",
        description = "Vamos planejar nossas próximas férias juntos. Confira as opções!",
        time = "12/06",
        categories = listOf(
            SimpleButton("Família", Color(0x20F4884B), Color(0xFFF4884B)),
            SimpleButton("Férias", Color(0x20F4884B), Color(0xFFF4884B))
        ),
        userInitial = "T",
        category = "Família"
    ),
    EmailData(
        title = "FreeCodeCamp",
        description = "Junte-se a nós para uma sessão de webinar informativa amanhã.",
        time = "12/06",
        categories = listOf(
            SimpleButton("Educação", Color(0x20F44B4B), Color(0xFFF44B4B)),
            SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4))
        ),
        userInitial = "F",
        category = "Educação"
    )
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
                scaffoldState = scaffoldState,
                modifier = Modifier.fillMaxWidth(),
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
                        },
                        actions = {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(end = 6.dp)
                                    .size(40.dp)
                            )
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
                    Content(navController)
                    BottomRightButton(navController)
                }
            )
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
// modifier = Modifier.fillMaxSize().padding(18.dp),
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
                            Text(text = "Menu", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold, color = Color(0xFF0c0c0c))

                            Column() {
                                IconButton(onClick = onClose) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.home),
                                            contentDescription = "Home"
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(text = "Caixa de Entrada", fontSize = 16.sp, color = Color(0xFF0c0c0c))
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
                                                Text(text = menuItem.title, fontSize = 16.sp, color = Color(0xFF0c0c0c))
                                            }
                                        }
                                    )
                                }
                            }
                        }
            }
}

@Composable
fun Content(navController: NavHostController) {
    val selectedCategory = remember { mutableStateOf("") }
    val buttonsScrollState = rememberScrollState()

// Botões padrões de categorias
    val buttons = listOf(
        Button("Todos", R.drawable.grid, Color(0x2066D563), Color(0xFF66D563)),
        Button("Educação", R.drawable.book_open, Color(0x20F44B4B), Color(0xFFF44B4B)),
        Button("Família", R.drawable.family, Color(0x20F4884B), Color(0xFFF4884B)),
        Button("Importante", R.drawable.important, Color(0x20EDC254), Color(0xFFEDC254)),
        Button("Propaganda", R.drawable.gift, Color(0x20B44BF4), Color(0xFFB44BF4)),
        Button("Social", R.drawable.users, Color(0x204BA3F4), Color(0xFF4BA3F4))
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(buttonsScrollState)
                .padding(start = 24.dp, top = 16.dp, bottom = 16.dp)
        ) {
            buttons.forEachIndexed { index, button ->
                FilledTonalButton(
                    onClick = {
                        selectedCategory.value = if (button.label == "Todos") "" else button.label
                    },
                    modifier = Modifier.padding(end = if (index == buttons.size - 1) 24.dp else 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = button.containerColor),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(
                        start = 10.dp,
                        end = 10.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                ) {
                    Image(
                        painter = painterResource(id = button.iconId),
                        contentDescription = button.label
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(button.label, color = button.tintColor, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        CardList(navController = navController, selectedCategory = selectedCategory.value)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DynamicCard(
    navController: NavController,
    title: String,
    description: String,
    time: String,
    categories: List<SimpleButton>,
    userInitial: String
) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("email-info")
                    }
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Row(modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 24.dp)) {
                        Column(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFF95F44B), shape = CircleShape)
                                .clip(CircleShape)
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Text(
                                text = userInitial,
                                color = Color(0xFF4D8D1D),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Column(Modifier.weight(1f)) {
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 10.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(bottom = 6.dp),
                                        color = Color(0xFF0c0c0c)
                                    )
                                    Text(
                                        text = description,
                                        color = Color.Gray,
                                        fontSize = 14.sp,
                                        style = TextStyle(
                                            lineHeight = 20.sp
                                        )
                                    )
                                }
                                Column {
                                    Text(
                                        text = time,
                                        color = Color.Gray,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                            FlowRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                categories.forEach { button ->
                                    FilledTonalButton(
                                        onClick = { println(button.label) },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = button.containerColor,
                                            disabledContainerColor = button.containerColor
                                        ),
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

@Composable
fun CardList(navController: NavController, selectedCategory: String) {
    // Filtrar os emails pela categoria selecionada
    val filteredEmails = remember(selectedCategory) {
        if (selectedCategory.isBlank() || selectedCategory == "Todos") {
            emails
        } else {
            emails.filter { email ->
                email.categories.any { it.label == selectedCategory }
            }
        }
    }

    // Mostrar um Text quando não houver emails com a categoria filtrada
    if (filteredEmails.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text("Não existem emails com a categoria filtrada.", fontSize = 14.sp, color = Color.Gray)
        }
    } else {
        LazyColumn {
            items(filteredEmails) { email ->
                DynamicCard(
                    navController = navController,
                    title = email.title,
                    description = email.description,
                    time = email.time,
                    categories = email.categories,
                    userInitial = email.userInitial
                )
            }
        }
    }
}

@Composable
fun BottomRightButton(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        contentAlignment = Alignment.BottomEnd
    ) {
        ElevatedButton(
            onClick = { navController.navigate("novo-email") },
            modifier = Modifier
                .height(60.dp) // Define a altura do botão
                .widthIn(min = 130.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(174, 218, 45)
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(25.dp),
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp,
                bottom = 10.dp
            ),

            ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_edit),
                    tint = Color(0, 0, 0),
                    contentDescription = "Escrever",
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Escrever", color = Color(0, 0, 0), fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
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