package eu.limereversed.werkout

import android.app.Application
import eu.limereversed.werkout.Graph

// Creates the database
class GraphApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}