package com.ruben.classapps.BoardgamesApp

data class Game(
    var name: String,
    var category: GameCategory,
    var isSelected: Boolean = false
)