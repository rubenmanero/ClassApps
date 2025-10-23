package com.ruben.classapps.BoardgamesApp

data class Game (val name: String, val gameCategory: GameCategory, var isSelected: Boolean = false)