package com.example.thursdaytriviaapp3.data

import com.example.thursdaytriviaapp3.R
import com.example.thursdaytriviaapp3.model.DataModel

class DataSource {
    fun loadDataModels(): List<DataModel> {
        return listOf<DataModel>(
            DataModel(R.drawable.image1, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image2, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image3, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image4, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image5, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image6, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image7, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image8, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image9, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3),
            DataModel(R.drawable.image10, R.string.DataModel1, R.string.DataModel2, R.string.DataModel3))
    }
}