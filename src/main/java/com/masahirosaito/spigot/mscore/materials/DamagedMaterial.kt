package com.masahirosaito.spigot.mscore.events.materials

import org.bukkit.Material
import org.bukkit.block.Block

data class DamagedMaterial(val material: Material, val damage: Short) {
    companion object {
        fun new(block: Block): DamagedMaterial {
            return DamagedMaterial(block.type, block.state.data.toItemStack().durability)
        }
    }
}