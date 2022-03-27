package ru.netology

fun main() {

    val result = calcDiscount(
        card = "Mastercard",
        totalPurchase = 130_000_00,
        purchase = 50_000_00
    )
    println("Комиссия составит $result копеек")
}

fun calcDiscount (card: String = "Vk Pay", totalPurchase: Int = 0, purchase: Int): Number {
    val commission: Number = when (card) {
        "Mastercard", "Maestro" -> {
            if (totalPurchase < 75_000_00) {
                0
            } else {
                purchase * 0.6 / 100 + 20_00
            }
        }
        "Visa", "Мир" -> {
            if (purchase * 0.75 / 100 < 35_00) {
                35_00
            } else {
                purchase * 0.75 / 100
            }
        }
        else -> 0
    }
    return commission
}