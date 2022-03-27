package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun `calcDiscount card Mastercard & Maestro if`() {
        val card = "Mastercard"
        val totalPurchase = 50_000_00
        val purchase = 30_000_00
        val expectedCommission = 0

        val actualCommission = calcDiscount(card, totalPurchase, purchase)

        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun `calcDiscount card Mastercard & Maestro else`() {
        val card = "Maestro"
        val totalPurchase = 150_000_00
        val purchase = 45_000_00
        val expectedCommission = purchase * 0.6 / 100 + 20_00

        val actualCommission = calcDiscount(card, totalPurchase, purchase)

        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun `calcDiscount card Visa & Mir if`() {
        val card = "Visa"
        val totalPurchase = 30_000_00
        val purchase = 2_000_00
        val expectedCommission = 35_00

        val actualCommission = calcDiscount(card, totalPurchase, purchase)

        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun `calcDiscount card Visa & Mir else`() {
        val card = "Мир"
        val totalPurchase = 30_000_00
        val purchase = 15_000_00
        val expectedCommission = purchase * 0.75 / 100

        val actualCommission = calcDiscount(card, totalPurchase, purchase)

        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun `calcDiscount card Vk Pay`() {
        val card = "Vk Pay"
        val totalPurchase = 0
        val purchase = 5_000_00
        val expectedCommission = 0

        val actualCommission = calcDiscount(card, totalPurchase, purchase)

        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun `calcDiscount default`() {
        val purchase = 2_000_00
        val expectedCommission = 0

        val actualCommission = calcDiscount(purchase = purchase)

        assertEquals(expectedCommission, actualCommission)
    }
}