package com.example.studentsmanagement.dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupWindow
import com.example.studentsmanagement.base.BaseActivity
import com.example.studentsmanagement.databinding.CancelDropDownMenuBinding

object CancelDropDownMenu {

    fun showDropDown(
        activity: BaseActivity<*>,
        view: View,
        callback: (reason : String) -> Unit
    ) {
        val layoutInflater: LayoutInflater =
            activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = CancelDropDownMenuBinding.inflate(layoutInflater)
        val popupView: View = binding.root
        val popupWindow = PopupWindow(popupView, FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)

        binding.health.setOnCheckedChangeListener { _, isChecked ->
            run {
                if (isChecked) {
                    popupWindow.dismiss()
                    callback("Lý do sức khỏe")
                }
            }
        }

        binding.family.setOnCheckedChangeListener { _, isChecked ->
            run {
                if (isChecked) {
                    popupWindow.dismiss()
                    callback("Lý do gia đình")
                }
            }
        }

        binding.orther.setOnCheckedChangeListener { _, isChecked ->
            run {
                if (isChecked) {
                    popupWindow.dismiss()
                    callback("Lý do khác")
                }
            }
        }


        popupWindow.isOutsideTouchable = true
        popupWindow.showAsDropDown(view)
    }
}