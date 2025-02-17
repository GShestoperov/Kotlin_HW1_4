package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun testCalcTransferCommission_Test1() {
        val transferAmount = 0
        val cardType = "Mastercard"
        val dayTransfer = 0
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcTransferCommission_Test2() {
        val transferAmount = 1000
        val cardType = "Mastercard"
        val dayTransfer = 150_000
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(ERROR_DAY_ONE_LIMIT, result)
    }

    @Test
    fun testCalcTransferCommission_Test3() {
        val transferAmount = 1000
        val cardType = "Mastercard"
        val dayTransfer = 0
        val monthTransfer = 600_000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(ERROR_MONTH_LIMIT, result)
    }

    @Test
    fun testCalcTransferCommission_Test4() {
        val transferAmount = 1000
        val cardType = "Mastercard"
        val dayTransfer = 0
        val monthTransfer = 100_000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(26, result)
    }

    @Test
    fun testCalcTransferCommission_Test5() {
        val transferAmount = 1000
        val cardType = "Maestro"
        val dayTransfer = 0
        val monthTransfer = 50_000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcTransferCommission_Test6() {
        val transferAmount = 100
        val cardType = "Maestro"
        val dayTransfer = 0
        val monthTransfer = 100

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(20, result)
    }

    @Test
    fun testCalcTransferCommission_Test7() {
        val transferAmount = 1000
        val cardType = "Visa"
        val dayTransfer = 0
        val monthTransfer = 50_000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(35, result)
    }

    @Test
    fun testCalcTransferCommission_Test8() {
        val transferAmount = 20_000
        val cardType = "VK Pay"
        val dayTransfer = 0
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(ERROR_DAY_ONE_LIMIT, result)
    }

    @Test
    fun testCalcTransferCommission_Test9() {
        val transferAmount = 10_000
        val cardType = "VK Pay"
        val dayTransfer = 0
        val monthTransfer = 50_000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(ERROR_MONTH_LIMIT, result)
    }

    @Test
    fun testCalcTransferCommission_Test10() {
        val transferAmount = 1000
        val cardType = "VK Pay"
        val dayTransfer = 0
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcTransferCommission_Test11() {
        val transferAmount = 1000
        val cardType = "VK Pay2"
        val dayTransfer = 0
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(ERROR_CARD_TYPE, result)
    }

    @Test
    fun testCalcTransferCommission_Test12() {
        val transferAmount = 1000
        val cardType = "Мир"
        val dayTransfer = 0
        val monthTransfer = 0

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(35, result)
    }

}