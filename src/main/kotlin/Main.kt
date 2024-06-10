package ru.netology

import kotlin.math.max

const val LIMIT_DAY = 150_000
const val LIMIT_MONTH = 600_000
const val LIMIT_MASTERCARD_MONTH = 75_000

fun main() {
    print(commission("MasterCard", 76000))
}

fun commission(typeCard: String = "Мир", amount: Int, amountOfMonth: Int = 0): Int {
    if (amount > LIMIT_DAY || amount + amountOfMonth > LIMIT_MONTH) {
        println("Привышен лимит")
        return 0
    } else return when (typeCard) {
        "MasterCard" -> if (amount + amountOfMonth <= LIMIT_MASTERCARD_MONTH) return 0 else
            ((amount + amountOfMonth - LIMIT_MASTERCARD_MONTH) * 0.006).toInt() + 20

        "Visa" -> return max(35, (amount * 0.0075).toInt())
        else -> return 0
    }
}


