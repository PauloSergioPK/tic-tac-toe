package com.psrc.common.domain.model

data class TicTacToe(
    private val houses: MutableList<MoveTypes?> = MutableList(9) { null }
) {

    fun addMove(houseIndex: Int, moveType: MoveTypes) {
        if (houseIndex <= houses.lastIndex && houses[houseIndex] == null) {
            houses[houseIndex] = moveType
        }
    }

    fun getHouses() = houses.toList()

}