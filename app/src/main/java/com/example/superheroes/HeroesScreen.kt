package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.res.dimensionResource
import com.example.superheroes.model.HeroesRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun ListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(hero.imageResourceId)
    val contentDescription = stringResource(hero.descriptionRes)
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
//        modifier = modifier,
        modifier = Modifier
//            .background(color = Color.Blue)
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_small)
            ),
//        modifier = Modifier
//            .background(color = Color.Blue)
//            .clip(MaterialTheme.shapes.medium),
    ) {
        Row(
//            horizontalArrangement = Arrangement
//                .spacedBy(
//                    space = 16.dp,
//                    alignment = Alignment.CenterHorizontally
//                ),
            modifier = Modifier
                .fillMaxWidth()
//                .background(color = Color.Red)
                .padding(16.dp)
                .sizeIn(minHeight = dimensionResource(id = R.dimen.image_size)),
        ){
            Column(
                modifier = Modifier
                    .weight(1f) // take up rest of row minus img size
            ) {
                Text(
                    text = stringResource(hero.stringResourceId),
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text= stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodySmall,
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size)),
            ){
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small),
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            HeroTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                ListItem(
                    hero = it,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview("Hero Test")
@Composable
fun Test() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        HeroList(heroes = HeroesRepository.heroes)
    }
}