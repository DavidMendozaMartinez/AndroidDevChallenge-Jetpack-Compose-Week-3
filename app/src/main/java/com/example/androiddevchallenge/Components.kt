/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Content
import com.example.androiddevchallenge.data.favoriteItems
import com.example.androiddevchallenge.ui.theme.shapes
import dev.chrisbanes.accompanist.glide.GlideImage
import java.util.Locale

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo_content_description),
        modifier = modifier
    )
}

@Composable
fun Background(
    backgroundId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = backgroundId),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun FavoriteComponent(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier
    )
    FavoriteGrid(
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Composable
fun FavoriteGrid(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        modifier = modifier
    ) {
        items(favoriteItems.chunked(2)) { chunk ->
            Column {
                FavoriteItem(content = chunk[0], modifier = Modifier.padding(bottom = 8.dp))
                FavoriteItem(content = chunk[1])
            }
        }
    }
}

@Composable
fun FavoriteItem(
    content: Content,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colors.surface,
        modifier = modifier.size(192.dp, 56.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                content.imgUrl,
                modifier = Modifier.size(56.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Text(
                text = content.text,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 16.dp, end = 4.dp)
            )
        }
    }
}

@Composable
fun AlignComponent(
    text: String,
    items: List<Content>,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier
    )

    AlignLinear(
        items = items,
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Composable
fun AlignLinear(
    items: List<Content>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        modifier = modifier
    ) {
        items(items) { item ->
            AlignItem(content = item)
        }
    }
}

@Composable
fun AlignItem(content: Content) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            content.imgUrl,
            modifier = Modifier.size(88.dp).clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Text(
            text = content.text,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.firstBaselineToTop(24.dp)
        )
    }
}

@Composable
fun FilledTextField(
    label: String,
    leadingIcon: ImageVector?,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = MaterialTheme.colors.onSurface
                )
            }
        },
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = leadingIcon?.let { Modifier.padding(top = 4.dp) } ?: Modifier.padding(top = 4.dp, start = 8.dp)
            )
        }
    )
}

@Composable
fun ContainedButton(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.button,
            color = textColor
        )
    }
}
