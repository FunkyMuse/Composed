package com.funkymuse.composedlib.features

import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.features.bottom_sheets.CyanBottomSheetDialogGraphEntry
import com.funkymuse.composedlib.features.bottom_sheets.GreenBottomSheetDialogGraphEntry
import com.funkymuse.composedlib.features.dialogs.red.RedDialogGraphEntry
import com.funkymuse.composedlib.features.dialogs.yellow.YellowDialogGraphEntry
import com.funkymuse.composedlib.features.favorites.FavoritesScreenGraphEntry
import com.funkymuse.composedlib.features.home.HomeScreenGraphEntry
import com.funkymuse.composedlib.features.login.LoginScreenGraphEntry
import com.funkymuse.composedlib.features.settings.SettingsScreenGraphEntry
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.BottomSheetsGraph
import com.funkymuse.composedlib.navigation.destinations.dialogs.DialogsGraph
import com.funkymuse.composedlib.navigation.destinations.favorites.graph.FavoritesGraph
import com.funkymuse.composedlib.navigation.destinations.home.graph.HomeGraph
import com.funkymuse.composedlib.navigation.destinations.login.LoginGraph
import com.funkymuse.composedlib.navigation.destinations.settings.graph.SettingsGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@InstallIn(SingletonComponent::class)
@Module
internal object FeaturesModule {

    @Provides
    @IntoMap
    @ClassKey(FavoritesGraph::class)
    fun favoritesEntries(favoritesScreenGraphEntry: FavoritesScreenGraphEntry): Set<NavigationGraphEntry> = setOf(favoritesScreenGraphEntry)

    @Provides
    @IntoMap
    @ClassKey(HomeGraph::class)
    fun homeEntries(homeScreenGraphEntry: HomeScreenGraphEntry): Set<NavigationGraphEntry> = setOf(homeScreenGraphEntry)

    @Provides
    @IntoMap
    @ClassKey(SettingsGraph::class)
    fun settingsEntries(settingsScreenGraphEntry: SettingsScreenGraphEntry): Set<NavigationGraphEntry> = setOf(settingsScreenGraphEntry)

    @Provides
    @IntoMap
    @ClassKey(LoginGraph::class)
    fun loginEntries(loginScreenGraphEntry: LoginScreenGraphEntry): Set<NavigationGraphEntry> = setOf(loginScreenGraphEntry)

    @Provides
    @IntoMap
    @ClassKey(DialogsGraph::class)
    fun dialogEntries(
        yellowDialogGraphEntry: YellowDialogGraphEntry,
        redDialogGraphEntry: RedDialogGraphEntry
    ): Set<NavigationGraphEntry> = setOf(yellowDialogGraphEntry, redDialogGraphEntry)

    @Provides
    @IntoMap
    @ClassKey(BottomSheetsGraph::class)
    fun bottomSheetEntries(
        testDialogGraphEntry: GreenBottomSheetDialogGraphEntry,
        test2DialogGraphEntry: CyanBottomSheetDialogGraphEntry
    ): Set<NavigationGraphEntry> = setOf(testDialogGraphEntry, test2DialogGraphEntry)


}