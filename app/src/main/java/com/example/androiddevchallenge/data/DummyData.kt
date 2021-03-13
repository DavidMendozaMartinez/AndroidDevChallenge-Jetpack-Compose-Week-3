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
package com.example.androiddevchallenge.data

val favoriteItems = listOf(
    Content("Short mantras", "https://images.pexels.com/photos/1825206/pexels-photo-1825206.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
    Content("Nature meditations", "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Stress and anxiety", "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Self-massage", "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"),
    Content("Overwhelmed", "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Nightly wind down", "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
)

val alignBodyItems = listOf(
    Content("Inversions", "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Quick yoga", "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Stretching", "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Tabata", "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("HIIT", "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Pre-natal yoga", "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
)

val alignMindItems = listOf(
    Content("Meditate", "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("With kids", "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("Aromatherapy", "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"),
    Content("On the go", "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"),
    Content("With pets", "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"),
    Content("High stress", "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
)

data class Content(val text: String, val imgUrl: String)
