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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Background
import com.example.androiddevchallenge.ContainedButton
import com.example.androiddevchallenge.Logo
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen

@Composable
fun Welcome(navController: NavController?) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Background(backgroundId = R.drawable.welcome)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            Spacer(modifier = Modifier.height(32.dp))
            ContainedButton(
                text = stringResource(id = R.string.sign_up),
                backgroundColor = MaterialTheme.colors.primary,
                textColor = MaterialTheme.colors.onPrimary,
                onClick = {},
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ContainedButton(
                text = stringResource(id = R.string.log_in),
                backgroundColor = MaterialTheme.colors.secondary,
                textColor = MaterialTheme.colors.onSecondary,
                onClick = { navController?.navigate(Screen.LoginScreen.route) },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}
