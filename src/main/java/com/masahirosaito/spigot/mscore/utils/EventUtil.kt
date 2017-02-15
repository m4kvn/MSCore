package com.masahirosaito.spigot.mscore.utils

import org.bukkit.event.Event
import org.bukkit.plugin.java.JavaPlugin

fun <T : Event> T.call(plugin: JavaPlugin) = apply { plugin.server.pluginManager.callEvent(this) }