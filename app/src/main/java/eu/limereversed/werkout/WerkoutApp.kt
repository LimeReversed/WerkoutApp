package eu.limereversed.werkout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import eu.limereversed.werkout.ui.theme.*

@Composable
fun ExercisePage(exercise: Exercise) {
    Column(verticalArrangement = Arrangement.Center)
    {

        Image(
            painter = painterResource(id = exercise.imageID),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkPurple)
                .padding(end = 10.dp, start = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    "Te: ${exercise.tempo}",
                    color = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp),
                    fontSize = 3.em
                )
                Text(
                    "Res: ${exercise.rest}s",
                    color = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp),
                    fontSize = 3.em
                )
                Text(
                    "Eq: ${exercise.equipment}",
                    color = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp),
                    fontSize = 3.em
                )
            }
        }

        var rowHeight = 25.dp
        Row(modifier = Modifier
            .height(rowHeight)
            .background(SoftBlack)) {

            Column(
                modifier = Modifier
                    .height(rowHeight)
                    .width(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {

            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(rowHeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(rowHeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
            }
        }

        var rowNr: Int = 1
        LazyColumn(){
            items(exercise.sets){
                SetCard(it, rowNr)
                rowNr++
            }
        }
    }
}

@Composable
fun SetCard(set: Set, rowNr: Int) {

    // Array of each part of the set, so I can loop the columns? [SetItem(reps), SetItem(weight)]
    var rowHeight = 25.dp


    Row(modifier = Modifier
        .height(rowHeight * 2)
        .background(DarkGreyPurple)) {

        Column(
            modifier = Modifier
                .width(25.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(rowNr.toString())
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
        }
    }

    Row(modifier = Modifier
        .height(rowHeight)
        .background(DarkGreyPurple)) {

        Column(
            modifier = Modifier
                .width(25.dp)
                .height(rowHeight),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text("G")
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .height(rowHeight),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .height(rowHeight),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WerkoutApp(innerPadding: PaddingValues) {

    val sets: MutableList<Set> = mutableListOf<Set>(
        Set(
            8,
            WeightUnits.Kgs,
            12.0f
        ), Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ),
        Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ),
        Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ), Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ), Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ), Set(
            12,
            WeightUnits.Kgs,
            8.0f
        ), Set(
            12,
            WeightUnits.Kgs,
            8.0f
        )
    )
    val exercises by remember {
        mutableStateOf(
            listOf<Exercise>(
                Exercise("TestName", R.drawable.machine, "0 0 1 0", 60, "Smith machine", sets),
                Exercise("TestName2", R.drawable.machine, "0 1 1 0", 45, "", sets),
                Exercise("TestName3", R.drawable.machine, "1 1 1 0", 30, "", sets),
            )
        )
    }


    val pagerState = rememberPagerState(pageCount = {
        exercises.size
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top

        ) { page ->

            ExercisePage(exercises[page])

        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    WerkoutTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("ABC", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        DarkPurple

                    )
                )
            }) { innerPadding ->
            WerkoutApp(innerPadding)
        }
    }
}
