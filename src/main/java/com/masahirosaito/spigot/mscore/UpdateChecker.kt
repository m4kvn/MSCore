package com.masahirosaito.spigot.mscore

import org.bukkit.plugin.java.JavaPlugin
import java.net.URL

class UpdateChecker(val organization: String, val repository: String, val name: String) {

    val url = URL("https://bintray.com/$organization/$repository/$name/_latestVersion")

    fun getLatestVersion(): String {
        return url.openConnection().inputStream.bufferedReader().lines()
                .filter { it.contains(Regex("\"/$organization/$repository/$name/([\\d.]+\").*(title)")) }
                .map { it.apply { println(it) }.replace(Regex("<.+?>"), "") }.toArray().first() as String
    }

    fun isLatestVersion(plugin: JavaPlugin): Boolean {
        try {
            return plugin.description.version == getLatestVersion()
        } catch(e: Exception) {
            return true
        }
    }
}