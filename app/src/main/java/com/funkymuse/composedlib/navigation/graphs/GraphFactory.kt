package com.funkymuse.composedlib.navigation.graphs

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Responsible for concatenating your destinations and graphs
 */
@Suppress("UNCHECKED_CAST")
@Singleton
class GraphFactory @Inject constructor(
    private val destinations: Map<Class<*>, @JvmSuppressWildcards Set<NavigationGraphEntry>>,
    private val graphs: Map<@JvmSuppressWildcards Class<*>, @JvmSuppressWildcards NavigationGraph>,
) {

    fun <T : NavigationGraph> getGraphByRoute(uniqueRoute: Class<*>): T {
        val graph = graphs[uniqueRoute] as? T
        when {
            graph == null -> throw IllegalArgumentException("Graph with $uniqueRoute is not registered")
            graph.javaClass != uniqueRoute -> throw IllegalArgumentException("Graph should be of a type ${uniqueRoute.javaClass}")
            else -> return graph
        }
    }

    val graphsWithDestinations: Map<NavigationGraph, Set<NavigationGraphEntry>> =
        (destinations.keys.plus(graphs.keys).asSequence())
            .associate {
                graphs[it] to destinations[it]
            }.filter {
                it.key != null && it.value != null
            } as Map<NavigationGraph, Set<NavigationGraphEntry>>
}
