package com.example.studentsmanagement.dialog

import android.content.Context
import com.example.studentsmanagement.R
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseDialog
import com.example.studentsmanagement.databinding.DialogSignoutBinding

class SignOutDialog(context: Context, private val listener: OnClickListener): BaseDialog(context,R.style.tt_privacy_dialogTheme) {
    val binding = DialogSignoutBinding.inflate(layoutInflater)
    init {
        setContentView(binding.root)
        setCanceledOnTouchOutside(false)
        binding.run {
            tvCancel.setOnClickListener {
                dismiss()
            }
            tvCf.setOnClickListener {
                listener.onClickDetail()
                dismiss()
            }
        }
    }
}