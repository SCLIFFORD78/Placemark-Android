package org.wit.placemark.models


interface PlacemarkStore {
    fun findAll(): List<PlacemarkModel>
    fun update(placemark: PlacemarkModel)
    fun create(placemark: PlacemarkModel)
}