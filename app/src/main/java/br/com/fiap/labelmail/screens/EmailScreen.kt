package br.com.fiap.labelmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import br.com.fiap.labelmail.model.SimpleButton
import androidx.compose.material3.ElevatedButton


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EmailScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()

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
            EmailContent()
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EmailContent() {
    val categories = listOf(
          SimpleButton("Educação", Color(0x20F44B4B), Color(0xFFF44B4B)),
          SimpleButton("Social", Color(0x204BA3F4), Color(0xFF4BA3F4))
    )

    val remetente = "education@github.com"
    val assunto = "Estamos de volta com um conteúdo cheio de ação..."
    val mensagem = """
Olá!

Espero que esteja bem! Estamos entusiasmados em compartilhar com você as últimas novidades da GitHub Education, repletas de conteúdo inspirador e oportunidades educacionais emocionantes.

Nesta edição, estamos focando em proporcionar a você recursos que vão além do básico, ajudando a transformar suas habilidades em desenvolvimento e muito mais. Prepare-se para mergulhar em:

Workshops Interativos: Aprenda na prática com nossos workshops interativos, projetados para levar suas habilidades de programação para o próximo nível. De iniciantes a avançados, há algo para todos.

Recursos Exclusivos: Acesso a guias detalhados, estudos de caso de projetos reais e tutoriais passo a passo que ajudam a consolidar seu conhecimento de GitHub e além.

Eventos Comunitários: Participe de sessões ao vivo e painéis de discussão com especialistas do setor e membros da comunidade GitHub para insights valiosos e networking.

Além disso, como parte de nossa missão de apoiar a educação e inovação, estamos lançando novas iniciativas sociais destinadas a promover a diversidade e inclusão no campo da tecnologia. Juntos, podemos construir um futuro mais inclusivo e colaborativo.

Estamos comprometidos em ajudá-lo a alcançar seus objetivos educacionais e profissionais através de recursos de alta qualidade e suporte contínuo da comunidade GitHub.

Não hesite em nos informar se há algo específico que você gostaria de ver em futuras edições ou se tiver alguma dúvida. Estamos aqui para ajudar!

Obrigado por fazer parte da comunidade GitHub Education.

Atenciosamente,

GitHub Education Team
    """.trimIndent()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 24.dp, end = 24.dp),
    ) {
        item {
            Text(
                text = "De: $remetente",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        item {
            Text(
                text = "Assunto: $assunto",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                categories.forEach { button ->
                    ElevatedButton(
                        onClick = { println(button.label) },
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = button.containerColor,
                            disabledContainerColor = button.containerColor
                        ),
                        elevation = androidx.compose.material3.ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
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

        item {
            Text(
                text = mensagem,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(60.dp)
                        .widthIn(min = 130.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(174, 218, 45)
                    ),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                    shape = RoundedCornerShape(25.dp),
                    contentPadding = PaddingValues(
                        start = 10.dp,
                        end = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Responder", color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                    }
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(60.dp)
                        .widthIn(min = 130.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF55D0E1)
                    ),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                    shape = RoundedCornerShape(25.dp),
                    contentPadding = PaddingValues(
                        start = 10.dp,
                        end = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Encaminhar", color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailPreview() {
    val navController = rememberNavController()
    EmailScreen(navController)
}