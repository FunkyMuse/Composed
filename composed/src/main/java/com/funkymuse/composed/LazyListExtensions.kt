package com.funkymuse.composed

import androidx.compose.foundation.lazy.LazyListState

/**
 * Created by funkymuse on 4/4/21 to long live and prosper !
 */

fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

fun LazyListState.isScrolledToTheEndAndNotScrolling() = isScrolledToTheEnd() && !isScrollInProgress

fun LazyListState.lastVisibleIndex() = layoutInfo.visibleItemsInfo.lastOrNull()?.index

fun LazyListState.visibleItemsSize() = layoutInfo.visibleItemsInfo.size
