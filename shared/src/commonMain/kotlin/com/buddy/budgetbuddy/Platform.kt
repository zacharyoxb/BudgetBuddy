package com.buddy.budgetbuddy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform