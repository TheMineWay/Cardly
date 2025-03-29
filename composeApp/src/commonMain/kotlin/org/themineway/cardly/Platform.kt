package org.themineway.cardly

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform