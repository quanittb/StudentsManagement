package com.example.studentsmanagement.dialog

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.WindowManager
import com.example.studentsmanagement.R
import com.example.studentsmanagement.activity.SignInActivity
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseDialog
import com.example.studentsmanagement.databinding.DialogProfileBinding
import com.example.studentsmanagement.fragment.DetailProfileFragment
import com.example.studentsmanagement.lib.SharedPreferenceUtils
import com.google.android.material.dialog.InsetDialogOnTouchListener

class ProfileDialog(context: Context, private val listener: OnClickListener):BaseDialog(context, R.style.Theme_Dialog) {
    val binding = DialogProfileBinding.inflate(layoutInflater)
    init {
        setContentView(binding.root)
        setCanceledOnTouchOutside(true)
            binding.run {
                window?.apply {
                    setLayout((Resources.getSystem().displayMetrics.widthPixels*0.85).toInt(), WindowManager.LayoutParams.MATCH_PARENT)
                    setGravity(Gravity.START) // Hiển thị từ bên trái
                }
                icBack.setOnClickListener {
                    dismiss()
                }
                btnSignout.setOnClickListener {
                    SignInActivity.start(context,true)

                }
                btnProfile.setOnClickListener {
                    listener.onClickDetail()
                    dismiss()
                }
        }
    }
}