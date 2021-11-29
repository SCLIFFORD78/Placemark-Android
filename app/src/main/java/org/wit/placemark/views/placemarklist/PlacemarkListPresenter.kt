package org.wit.placemark.views.placemarklist

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.wit.placemark.main.MainApp
import org.wit.placemark.models.PlacemarkModel
import org.wit.placemark.views.editlocation.EditLocationView
import org.wit.placemark.views.placemark.PlacemarkView

class PlacemarkListPresenter(val view: PlacemarkListView) {

    var app: MainApp
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>

    init {
        app = view.application as MainApp
        registerMapCallback()
        registerRefreshCallback()
    }

    fun getPlacemarks() = app.placemarks.findAll()

    fun doAddPlacemark() {
        val launcherIntent = Intent(view, PlacemarkView::class.java)
        refreshIntentLauncher.launch(launcherIntent)
    }

    fun doEditPlacemark(placemark: PlacemarkModel) {
        val launcherIntent = Intent(view, PlacemarkView::class.java)
        launcherIntent.putExtra("placemark_edit", placemark)
        mapIntentLauncher.launch(launcherIntent)
    }

    fun doShowPlacemarksMap() {
        val launcherIntent = Intent(view, EditLocationView::class.java)
        refreshIntentLauncher.launch(launcherIntent)
    }
    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { getPlacemarks() }
    }
    private fun registerMapCallback() {
        mapIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {  }
    }
}