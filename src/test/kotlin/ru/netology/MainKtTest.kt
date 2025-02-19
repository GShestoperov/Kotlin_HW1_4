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
        val dayTransfer = DAY_LIMIT
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
        val monthTransfer = MONTH_LIMIT

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
        val monthTransfer = MONTH_LIMIT - 2000

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
        val monthTransfer = MONTH_LIMIT - 2000

        val result = calcTransferCommission(
            transferAmount = transferAmount,
            cardType = cardType,
            dayTransfer = dayTransfer,
            monthTransfer = monthTransfer
        )

        assertEquals(26, result)
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
        val monthTransfer = MONTH_LIMIT - 2000

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
        val transferAmount = VKPAY_ONE_LIMIT + 1000
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
        val transferAmount = 1000
        val cardType = "VK Pay"
        val dayTransfer = 0
        val monthTransfer = VKPAY_MONTH_LIMIT

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

    @Test
    fun testCalcTransferCommission_Test13() {
        val transferAmount = 1000
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
    fun testCalcReceivingCommission_Test1() {
        val receivingAmount = -1
        val cardType = "Mastercard"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcReceivingCommission_Test2() {
        val receivingAmount = 1000
        val cardType = "Mastercard"
        val dayReceiving = DAY_LIMIT
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(ERROR_DAY_ONE_LIMIT, result)
    }

    @Test
    fun testCalcReceivingCommission_Test3() {
        val receivingAmount = 1000
        val cardType = "Mastercard"
        val dayReceiving = 0
        val monthReceiving = MONTH_LIMIT

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(ERROR_MONTH_LIMIT, result)
    }

    @Test
    fun testCalcReceivingCommission_Test4() {
        val receivingAmount = 1000
        val cardType = "Mastercard"
        val dayReceiving = 0
        val monthReceiving = 75_000

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(26, result)
    }

    @Test
    fun testCalcReceivingCommission_Test5() {
        val receivingAmount = 1000
        val cardType = "Maestro"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcReceivingCommission_Test6() {
        val receivingAmount = 1000
        val cardType = "Visa"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(35, result)
    }

    @Test
    fun testCalcReceivingCommission_Test7() {
        val receivingAmount = 1000
        val cardType = "VK Pay"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(0, result)
    }

    @Test
    fun testCalcReceivingCommission_Test8() {
        val receivingAmount = 100
        val cardType = "Mastercard"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(20, result)
    }

    @Test
    fun testCalcReceivingCommission_Test9() {
        val receivingAmount = 100
        val cardType = "Mastercard2"
        val dayReceiving = 0
        val monthReceiving = 0

        val result = calcReceivingCommission(
            receivingAmount = receivingAmount,
            cardType = cardType,
            dayReceiving = dayReceiving,
            monthReceiving = monthReceiving
        )

        assertEquals(ERROR_CARD_TYPE, result)
    }
}