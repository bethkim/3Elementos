package com.example.a3elementos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a3elementos.ui.theme._3ElementosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _3ElementosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ExampleScreen(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Chip
        AssistChip(
            onClick = { /*TODO*/ },
            label = { Text("Segun parece solo remarca texto") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Tarjeta
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Tarjetita", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Aquí solo va el cuerpo de la targeta y ya")
            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        //Botón para diálogo
        Button(onClick = { showDialog = true }) {
            Text("Sale Mensajito?")
        }

        //Cuadro de diálogo
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Sis") },
                text = { Text("Nada mas que ver aquí que solo un diálogo emergente") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Nice :)")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3ElementosTheme {
        ExampleScreen()
    }
}
