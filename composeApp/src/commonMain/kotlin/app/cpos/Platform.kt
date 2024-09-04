package app.cpos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform