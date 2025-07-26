package eu.limereversed.werkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import eu.limereversed.werkout.ui.theme.DarkPurple
import eu.limereversed.werkout.ui.theme.WerkoutTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WerkoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title={Text("ABC", color=Color.White)},
                        colors = TopAppBarDefaults.topAppBarColors(DarkPurple, Color.White))
                }) { innerPadding ->
                    WerkoutApp(innerPadding)
                }
            }
        }
    }
}

