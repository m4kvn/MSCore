package com.masahirosaito.spigot.mscore.utils

import org.bukkit.inventory.ItemStack

fun ItemStack.isBreak(damage: Int) = durability + damage >= type.maxDurability

fun ItemStack.damage(damage: Int) = this.apply { durability = durability.plus(damage).toShort() }

fun ItemStack.isBroken() = durability >= type.maxDurability

val ItemStack.remainingDurability: Int get() = type.maxDurability - durability