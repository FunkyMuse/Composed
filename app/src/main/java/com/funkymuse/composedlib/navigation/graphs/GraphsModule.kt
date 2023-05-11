package com.funkymuse.composedlib.navigation.graphs

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.BottomSheetsGraph
import com.funkymuse.composedlib.navigation.destinations.dialogs.DialogsGraph
import com.funkymuse.composedlib.navigation.destinations.favorites.graph.FavoritesGraph
import com.funkymuse.composedlib.navigation.destinations.home.graph.HomeGraph
import com.funkymuse.composedlib.navigation.destinations.login.LoginGraph
import com.funkymuse.composedlib.navigation.destinations.settings.graph.SettingsGraph
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GraphsModule {

    @Binds
    @IntoMap
    @ClassKey(FavoritesGraph::class)
    abstract fun favoritesGraph(graph: FavoritesGraph): NavigationGraph

    @Binds
    @IntoMap
    @ClassKey(HomeGraph::class)
    abstract fun homeGraph(graph: HomeGraph): NavigationGraph

    @Binds
    @IntoMap
    @ClassKey(SettingsGraph::class)
    abstract fun settingsGraph(graph: SettingsGraph): NavigationGraph

    @Binds
    @IntoMap
    @ClassKey(LoginGraph::class)
    abstract fun loginGraph(graph: LoginGraph): NavigationGraph

    @Binds
    @IntoMap
    @ClassKey(BottomSheetsGraph::class)
    abstract fun bottomSheetsGraph(graph: BottomSheetsGraph): NavigationGraph

    @Binds
    @IntoMap
    @ClassKey(DialogsGraph::class)
    abstract fun dialogsGraph(graph: DialogsGraph): NavigationGraph


}