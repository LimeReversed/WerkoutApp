package eu.limereversed.werkout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import eu.limereversed.werkout.ui.theme.WerkoutTheme

enum class WeightUnits {
    Kgs, Lbs
}

class Set(
    val name: String,
    val thumbnail: String,
    val reps: Int,
    // Just have it as a string so they can choose for themselves?
    // What about max weight?
    val weightUnit: WeightUnits,
    val weight: Float,

    ) {

}

@Composable
fun SetCard(set: Set) {
    Row() {
        Text(set.name)
    }
}

@Composable
fun WerkoutApp(innerPadding: PaddingValues) {

    Text("lkjlkjlkjkl")
//    var sets by remember {mutableStateOf(listOf<Set>())}
//    sets += Set("TestName", "TestThumbnail", 0, WeightUnits.Kgs, 1.0f)
//
//    LazyColumn() {
//        items(sets){
//            SetCard(it)
//        }
//    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
        WerkoutApp(innerPadding = PaddingValues())
}
