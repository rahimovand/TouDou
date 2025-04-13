package com.example.toudou.logic

fun twoStringsChecker(
    arg1: String,
    arg2: String
): Boolean {
    val a = arg1.replace("\\s".toRegex(), "")
    val b = arg2.replace("\\s".toRegex(), "")
    return a.isNotEmpty() && b.isNotEmpty()
}
