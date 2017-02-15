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

fun Player.itemInMainHand() = inventory.itemInMainHand!!

fun Player.isCreativeMode() = gameMode == GameMode.CREATIVE

fun Player.onBreakItemInMainHand() {
    world.playSound(location, Sound.ENTITY_ITEM_BREAK, 1f, 1f)
    inventory.itemInMainHand = ItemStack(Material.AIR)
}

fun Player.incrementGeneralStatistic(plugin: JavaPlugin, statistic: Statistic, amount: Int? = null) {
    player.getStatistic(statistic).let {
        PlayerStatisticIncrementEvent(this, statistic, it, it + (amount ?: 1)).call(plugin).apply {
            if (!isCancelled) this.player.incrementStatistic(this.statistic, this.newValue - this.previousValue)
        }
    }
}

fun Player.incrementMaterialStatistic(plugin: JavaPlugin, statistic: Statistic, material: Material, amount: Int? = null) {
    player.getStatistic(statistic, material).let {
        PlayerStatisticIncrementEvent(this, statistic, it, it + (amount ?: 1), material).call(plugin).apply {
            if (!isCancelled) this.player.incrementStatistic(this.statistic, this.material, this.newValue - this.previousValue)
        }
    }
}

fun Player.incrementEntityStatistic(plugin: JavaPlugin, statistic: Statistic, entityType: EntityType, amount: Int? = null) {
    player.getStatistic(statistic, entityType).let {
        PlayerStatisticIncrementEvent(this, statistic, it, it + (amount ?: 1), entityType).call(plugin).apply {
            if (!isCancelled) this.player.incrementStatistic(this.statistic, this.entityType, this.newValue - this.previousValue)
        }
    }
}

fun Player.spawnExp(amount: Int) {
    location.world.spawn(location, ExperienceOrb::class.java).experience = amount
}

fun Player.spawnItem(itemStack: ItemStack) {
    location.world.dropItemNaturally(location, itemStack)
}