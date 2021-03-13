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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Background
import com.example.androiddevchallenge.ContainedButton
import com.example.androiddevchallenge.FilledTextField
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.firstBaselineToTop
import java.util.Locale

@Composable
fun Login(navController: NavController?) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Background(backgroundId = R.drawable.login)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.log_in).toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.firstBaselineToTop(200.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            FilledTextField(
                label = stringResource(id = R.string.email_address),
                leadingIcon = null,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            FilledTextField(
                label = stringResource(id = R.string.password),
                leadingIcon = null,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ContainedButton(
                text = stringResource(id = R.string.log_in),
                backgroundColor = MaterialTheme.colors.primary,
                textColor = MaterialTheme.colors.onPrimary,
                onClick = { navController?.navigate(Screen.HomeScreen.route) },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            val underLineStyle = MaterialTheme.typography.body1.toSpanStyle().copy(
                textDecoration = TextDecoration.Underline
            )
            val signUpMessage = buildAnnotatedString {
                append(stringResource(id = R.string.sign_up_message_first))
                withStyle(underLineStyle) {
                    append(stringResource(id = R.string.sign_up_message_second))
                }
            }
            Text(
                text = signUpMessage,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.firstBaselineToTop(32.dp)
            )
        }
    }
}
