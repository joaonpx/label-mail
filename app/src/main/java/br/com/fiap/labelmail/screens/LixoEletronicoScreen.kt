package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.labelmail.R
import br.com.fiap.labelmail.model.EmailData
import br.com.fiap.labelmail.model.SimpleButton
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LixoEletronicoScreen(navController: NavHostController) {
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
            LixoEletronicoContent(navController)
        }
    )
}

@Composable
fun LixoEletronicoContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Lixo Eletrônico", fontSize = 24.sp, modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 16.dp), fontWeight = FontWeight.Bold)

        LixoEletronicoCardList(navController)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LixoEletronicoDynamicCard(
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
                        .background(Color(0x206D7072), shape = CircleShape)
                        .clip(CircleShape)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(
                        text = userInitial,
                        color = Color(0xFF6D7072),
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
                                modifier = Modifier.padding(bottom = 6.dp)
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

@Composable
fun LixoEletronicoCardList(navController: NavController) {
    val emails = listOf(
        EmailData(
            title = "Promoções Rápidas Ltda.",
            description = "Ganhe dinheiro rápido e fácil, clique aqui!",
            time = "17:15",
            categories = listOf(
                SimpleButton("Promoção", Color(0x20B44BF4), Color(0xFFB44BF4)),
                SimpleButton("Spam", Color(0x206D7072), Color(0xFF6D7072))
            ),
            userInitial = "P"
        ),
        EmailData(
            title = "Sorte Online",
            description = "Parabéns! Você foi selecionado para ganhar um prêmio exclusivo.",
            time = "16:30",
            categories = listOf(
                SimpleButton("Promoção", Color(0x20B44BF4), Color(0xFFB44BF4)),
                SimpleButton("Spam", Color(0x206D7072), Color(0xFF6D7072))
            ),
            userInitial = "S"
        ),
        EmailData(
            title = "Viagens Econômicas",
            description = "Descontos especiais em pacotes de viagem para destinos incríveis!",
            time = "15:00",
            categories = listOf(
                SimpleButton("Promoção", Color(0x20B44BF4), Color(0xFFB44BF4)),
                SimpleButton("Spam", Color(0x206D7072), Color(0xFF6D7072))
            ),
            userInitial = "V"
        ),
        EmailData(
            title = "Prêmios Online",
            description = "Participe do nosso concurso e concorra a prêmios valiosos!",
            time = "14:00",
            categories = listOf(
                SimpleButton("Promoção", Color(0x20B44BF4), Color(0xFFB44BF4)),
                SimpleButton("Spam", Color(0x206D7072), Color(0xFF6D7072))
            ),
            userInitial = "P"
        ),
        EmailData(
            title = "Descontos Express",
            description = "Aproveite os descontos exclusivos em produtos de alta qualidade.",
            time = "12:30",
            categories = listOf(
                SimpleButton("Promoção", Color(0x20B44BF4), Color(0xFFB44BF4)),
                SimpleButton("Spam", Color(0x206D7072), Color(0xFF6D7072))
            ),
            userInitial = "D"
        )
    )

    LazyColumn {
        items(emails) { email ->
            LixoEletronicoDynamicCard(
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
