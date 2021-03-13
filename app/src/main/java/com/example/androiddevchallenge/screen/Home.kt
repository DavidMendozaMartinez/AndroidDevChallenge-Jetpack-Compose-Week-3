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
package com.example.androiddevchallenge.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.AlignComponent
import com.example.androiddevchallenge.FavoriteComponent
import com.example.androiddevchallenge.FilledTextField
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.alignBodyItems
import com.example.androiddevchallenge.data.alignMindItems
import com.example.androiddevchallenge.firstBaselineToTop
import java.util.Locale

@Composable
fun Home() {
    val fabShape = CircleShape
    val scaffoldState = rememberScaffoldState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.height(57.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 8.dp
                ) {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                modifier = Modifier.size(18.dp),
                                imageVector = Icons.Default.Spa,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.home).toUpperCase(Locale.getDefault()),
                                style = MaterialTheme.typography.caption
                            )
                        },
                        selected = true,
                        alwaysShowLabel = true,
                        onClick = {}
                    )

                    BottomNavigationItem(
                        icon = {
                            Icon(
                                modifier = Modifier.size(18.dp),
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.profile).toUpperCase(Locale.getDefault()),
                                style = MaterialTheme.typography.caption
                            )
                        },
                        selected = false,
                        alwaysShowLabel = true,
                        onClick = {}
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                    shape = fabShape,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    ),
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            },
            content = {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(56.dp))
                    FilledTextField(
                        label = stringResource(id = R.string.search),
                        leadingIcon = Icons.Default.Search,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )

                    FavoriteComponent(
                        text = stringResource(id = R.string.favorite_collections),
                        modifier = Modifier
                            .firstBaselineToTop(40.dp)
                            .padding(start = 16.dp)
                    )

                    AlignComponent(
                        text = stringResource(id = R.string.align_your_body),
                        items = alignBodyItems,
                        modifier = Modifier
                            .firstBaselineToTop(48.dp)
                            .padding(start = 16.dp)
                    )

                    AlignComponent(
                        text = stringResource(id = R.string.align_your_mind),
                        items = alignMindItems,
                        modifier = Modifier
                            .firstBaselineToTop(48.dp)
                            .padding(start = 16.dp)
                    )
                }
            }
        )
    }
}
