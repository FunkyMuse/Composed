package com.funkymuse.composed.core

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.derivedStateOf

/**
 * Created by funkymuse on 4/4/21 to long live and prosper !
 */

fun LazyListState.isScrolledToTheEnd() =
    derivedStateOf { layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1 }.value

fun LazyListState.isScrolledToTheEndAndNotScrolling() =
    derivedStateOf { isScrolledToTheEnd() && !isScrollInProgress }.value

fun LazyListState.lastVisibleIndex() =
    derivedStateOf { layoutInfo.visibleItemsInfo.lastOrNull()?.index }.value

fun LazyListState.visibleItemsSize() = derivedStateOf { layoutInfo.visibleItemsInfo.size }.value

fun LazyListState.totalItemsCount() = derivedStateOf { layoutInfo.totalItemsCount }.value

fun LazyListState.viewportEndOffset() = derivedStateOf { layoutInfo.viewportEndOffset }.value

fun LazyListState.viewportStartOffset() = derivedStateOf { layoutInfo.viewportStartOffset }.value
