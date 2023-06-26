package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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

@Preview(showBackground = true)
@Composable
fun ListItem(modifier: Modifier = Modifier) {
    val painter = painterResource(R.drawable.android_superhero1)
    val contentDescription = stringResource(id = R.string.description1)
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .background(color=Color.Blue)
            .clip(MaterialTheme.shapes.medium),
    ) {
        Row(
            horizontalArrangement = Arrangement
                .spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterHorizontally
                ),
            modifier = Modifier
                .background(color= Color.Red)
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp),
        ){
            Column() {
                Text(
                    text = "title",
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text="description",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Box(
                modifier = Modifier
                    .height(72.dp)
            ){
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small),
                )
            }
            }
    }
}