package com.funkymuse.composedlib.navigation

import com.funkymuse.composedlib.navigation.destinations.home.graph.HomeGraph
import com.funkymuse.composedlib.navigation.graphs.GraphFactory
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class DynamicGraphDestinationProvider @Inject constructor(
    private val graphFactory: GraphFactory,
) {

    private val homeGraph get() = graphFactory.getGraphByRoute<HomeGraph>(HomeGraph::class.java)

    fun getStartingDestination(): String = homeGraph.route
}
