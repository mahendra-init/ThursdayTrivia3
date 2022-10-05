package com.example.thursdaytriviaapp3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DataModel(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titlestringResourceId: Int,
    @StringRes val menustringResourceId: Int,
    @StringRes val ratestringResourceId: Int
)
