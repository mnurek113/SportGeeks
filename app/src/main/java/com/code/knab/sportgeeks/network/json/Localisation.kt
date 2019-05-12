package com.code.knab.sportgeeks.network.json

import com.code.knab.sportgeeks.network.model.SportType

data class Localisation (val id: Long,
                         val name: String,
                         val description: String,
                         val center: LocalisationPoint,
                         val polygonPoints: List<LocalisationPoint>,
                         val sportTypes: List<SportType>)