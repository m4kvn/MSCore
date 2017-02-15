package com.masahirosaito.spigot.mscore.utils

import org.bukkit.inventory.ItemStack

val ItemStack.remainingDurability: Int get() = type.maxDurability - durability

fun ItemStack.isBreak(damage: Int) = durability + damage >= type.maxDurability

fun ItemStack.isBroken(): Boolean = durability >= type.maxDurability