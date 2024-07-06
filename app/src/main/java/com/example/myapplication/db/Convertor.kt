package com.example.myapplication.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Convertors {
    @TypeConverter
    fun fromBitMap(btm:Bitmap) : ByteArray {
        val outputStream = ByteArrayOutputStream()
        btm.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }
    @TypeConverter
    fun toBitMap(btArr: ByteArray):Bitmap {
        return BitmapFactory.decodeByteArray(btArr, 0, btArr.size)
    }
}