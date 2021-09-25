package org.wit.placemark.models

import PlacemarkModel

interface PlacemarkStore {
    fun findAll(): List<PlacemarkModel>
    fun update(placemark: PlacemarkModel)
    fun create(placemark: PlacemarkModel)
}