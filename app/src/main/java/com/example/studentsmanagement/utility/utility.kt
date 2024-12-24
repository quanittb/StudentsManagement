
package com.example.studentsmanagement.utility

import android.util.Log
import android.widget.Toast
import com.example.studentsmanagement.app.AppContext

fun showToast(mess:Any){
    Toast.makeText(AppContext.context, mess.toString(), Toast.LENGTH_LONG).show()
}

fun logD(value: Any){
    Log.d("abcd", "$value")
}


fun formatNumbers(inputNums : Float) : String{
    val formattedNumber = String.format("%.2f", inputNums).replace(",", ".")
    return if (formattedNumber.endsWith(".00")) {
        formattedNumber.replace(".00", "")
    } else if (formattedNumber.endsWith("0")) {
        formattedNumber.substring(0, formattedNumber.length - 1)
    } else {
        formattedNumber
    }
}

fun formatNumbers(inputNums : Double) : String{
    val formattedNumber = String.format("%.2f", inputNums).replace(",", ".")
    return if (formattedNumber.endsWith(".00")) {
        formattedNumber.replace(".00", "")
    } else if (formattedNumber.endsWith("0")) {
        formattedNumber.substring(0, formattedNumber.length - 1)
    } else {
        formattedNumber
    }
}



