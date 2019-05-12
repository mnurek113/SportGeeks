package com.code.knab.sportgeeks.network.json

import com.code.knab.sportgeeks.network.model.SportType

data class SportEvent(val id: Long?,
                      val startTime: String,
                      val price: Double,
                      val localisation: Localisation,
                      val sportType: SportType,
                      val orgarnisatorName: String,
                      val participationsNumber: Long)