package com.masahirosaito.spigot.mscore

import java.net.URL

class UpdateChecker(val organization: String, val repository: String, val name: String) {

    val url = URL("https://bintray.com/$organization/$repository/$name/_latestVersion")

    fun getLatestVersion(): String {
        return url.openConnection().inputStream.bufferedReader().lines()
                .filter { it.contains(Regex("\"/$organization/$repository/$name/([\\d.]+\").*(title)")) }
                .map { it.apply { println(it) }.replace(Regex("<.+?>"), "") }.toArray().first() as String
    }
}