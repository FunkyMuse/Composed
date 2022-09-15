package com.funkymuse.composed.core.lazylist

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

/**
 * Created by funkymuse on 8/4/21 to long live and prosper !
 */

@Composable
fun LazyListState.isScrolledToTheEndState() =
    remember(this) { derivedStateOf { isScrolledToTheEnd() } }

@Composable
fun LazyListState.isScrolledToTheEndAndNotScrollingState() =
    remember(this) { derivedStateOf { isScrolledToTheEndAndNotScrolling() } }

@Composable
fun LazyListState.lastVisibleIndexState() =
    remember(this) { derivedStateOf { lastVisibleIndex() } }

@Composable
fun LazyListState.firstVisibleIndexState() =
    remember(this) { derivedStateOf { firstVisibleIndex() } }

@Composable
fun LazyListState.visibleItemSizeState() =
    remember(this) { derivedStateOf { visibleItemsSize() } }

@Composable
fun LazyListState.totalItemsCountState() =
    remember(this) { derivedStateOf { totalItemsCount() } }

@Composable
fun LazyListState.viewportEndOffsetState() =
    remember(this) { derivedStateOf { viewportEndOffset() } }


@Composable
fun LazyListState.viewportStartOffsetState() =
    remember(this) { derivedStateOf { viewportStartOffset() } }


