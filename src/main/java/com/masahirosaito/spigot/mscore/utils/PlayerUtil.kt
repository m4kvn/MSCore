package com.masahirosaito.spigot.mscore.utils

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.bukkit.entity.ExperienceOrb
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerStatisticIncrementEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

val Player.itemInMainHand: ItemStack get() = inventory.itemInMainHand

fun Player.isCreativeMode() = gameMode == GameMode.CREATIVE

fun Player.spawnExp(amount: Int) {
    location.world.spawn(location, ExperienceOrb::class.java).experience = amount
}