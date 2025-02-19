package ru.netology

const val ERROR_CARD_TYPE = -1
const val ERROR_DAY_ONE_LIMIT = -2
const val ERROR_MONTH_LIMIT = -3
const val DAY_LIMIT = 150_000
const val MONTH_LIMIT = 600_000
const val VKPAY_ONE_LIMIT = 15_000
const val VKPAY_MONTH_LIMIT = 40_000

fun main() {

    val commission = calcTransferCommission(10000, "Mastercard", 100_000, 76_000)

    println("Комиссия перевода со счета составит: $commission руб.")

    val commissionReceiving = calcReceivingCommission(10000, "Visa", 100_000, 76_000)

    println("Комиссия перевода на счет составит: $commissionReceiving руб.")
}

// Расчет комиссии для приема денег на счет
fun calcReceivingCommission(receivingAmount: Int, cardType: String = "Мир", dayReceiving: Int = 0, monthReceiving: Int = 0): Int  {
    if (receivingAmount <= 0) {
        return 0
    }

    if (receivingAmount + dayReceiving > DAY_LIMIT) {
        return ERROR_DAY_ONE_LIMIT
    }

    if (receivingAmount + monthReceiving > MONTH_LIMIT) {
        return ERROR_MONTH_LIMIT
    }

    return when (cardType) {
        "VK Pay" -> {
            0
        }
        "Mastercard", "Maestro" -> {
            if (monthReceiving + receivingAmount < 300 || monthReceiving + receivingAmount > 75_000) {
                (receivingAmount * 0.006 + 20).toInt()
            } else {
                0
            }
        }
        "Visa", "Мир" -> {
            Math.max((receivingAmount * 0.0075).toInt(), 35)
        }
        else -> {
            ERROR_CARD_TYPE
        }
    }
}

// Расчет комиссии для перевода денег со счета
fun calcTransferCommission(transferAmount: Int, cardType: String = "Мир", dayTransfer: Int = 0, monthTransfer: Int = 0): Int {
    if (transferAmount <= 0) {
        return 0
    }

    if (transferAmount + dayTransfer > DAY_LIMIT) {
        return ERROR_DAY_ONE_LIMIT
    }

    if (transferAmount + monthTransfer > MONTH_LIMIT) {
        return ERROR_MONTH_LIMIT
    }

    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (monthTransfer + transferAmount < 300 || monthTransfer + transferAmount > 75_000) {
                (transferAmount * 0.006 + 20).toInt()
            } else {
                0
            }
        }

        "Visa", "Мир" -> {
            Math.max((transferAmount * 0.0075).toInt(), 35)
        }

        "VK Pay" -> {
            if (transferAmount > VKPAY_ONE_LIMIT) {
                return ERROR_DAY_ONE_LIMIT
            } else if (transferAmount + monthTransfer > VKPAY_MONTH_LIMIT) {
                return ERROR_MONTH_LIMIT
            }
            0
        }

        else -> {
            ERROR_CARD_TYPE
        }
    }
}

