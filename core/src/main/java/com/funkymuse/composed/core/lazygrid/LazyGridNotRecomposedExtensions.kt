package com.funkymuse.composed.core.lazygrid

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

/**
 * Created by funkymuse on 8/4/21 to long live and prosper !
 */

@Composable
fun LazyGridState.isScrolledToTheEndState() =
    remember(this) { derivedStateOf { isScrolledToTheEnd() } }

@Composable
fun LazyGridState.isScrolledToTheEndAndNotScrollingState() =
    remember(this) { derivedStateOf { isScrolledToTheEndAndNotScrolling() } }

@Composable
fun LazyGridState.lastVisibleIndexState() =
    remember(this) { derivedStateOf { lastVisibleIndex() } }

@Composable
fun LazyGridState.firstVisibleIndexState() =
    remember(this) { derivedStateOf { firstVisibleIndex() } }

@Composable
fun LazyGridState.visibleItemSizeState() =
    remember(this) { derivedStateOf { visibleItemsSize() } }

@Composable
fun LazyGridState.totalItemsCountState() =
    remember(this) { derivedStateOf { totalItemsCount() } }

@Composable
fun LazyGridState.viewportEndOffsetState() =
    remember(this) { derivedStateOf { viewportEndOffset() } }


@Composable
fun LazyGridState.viewportStartOffsetState() =
    remember(this) { derivedStateOf { viewportStartOffset() } }


