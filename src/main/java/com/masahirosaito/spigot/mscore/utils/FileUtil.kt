package com.masahirosaito.spigot.mscore.utils

import java.io.File

fun File.load(): File = this.apply {
    if (!parentFile.exists()) parentFile.mkdirs()
    if (!exists()) createNewFile()
}