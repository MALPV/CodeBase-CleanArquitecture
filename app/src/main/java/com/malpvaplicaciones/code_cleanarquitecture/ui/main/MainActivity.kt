package com.malpvaplicaciones.code_cleanarquitecture.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.malpvaplicaciones.code_cleanarquitecture.ui.theme.CodeCleanArquitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm by viewModels<MainVM>()

    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeCleanArquitectureTheme {
                // A surface container using the 'background' color from the theme

                LaunchedEffect(Unit) {

                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    when (val uiState = vm.uiState.collectAsState().value) {
                        MainState.Loading -> Text(text = "Loading")
                        is MainState.Error -> Text(text = "Error: ${uiState.message}")
                        else -> {
                            Column {
                                Text(text = "Content: Character count ${vm.characters.size}")
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeCleanArquitectureTheme {

    }
}