package com.masahirosaito.spigot.mscore

import org.bukkit.plugin.java.JavaPlugin

class MSCore : JavaPlugin() {
    lateinit var messenger: Messenger

    override fun onEnable() {
        messenger = Messenger(this, false)
    }

    override fun onDisable() {
    }
}
