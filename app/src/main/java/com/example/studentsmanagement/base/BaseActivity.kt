package com.example.studentsmanagement.base

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.studentsmanagement.R
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
    companion object {
        private val TAG = BaseActivity::class.java.name
    }

    protected lateinit var binding: V
    private var onFullscreen = false
    protected val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)


        decorView = window.decorView

        createView()
    }


    protected abstract fun getViewBinding(): V

    protected abstract fun createView()


    private var decorView: View? = null
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && onFullscreen) {
            decorView!!.systemUiVisibility = hideSystemBars()
        }
    }


    open fun hideSystemBars(): Int {
        return (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    protected open fun setFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            val windowInsetsController = window.insetsController
            if (windowInsetsController != null) {
                windowInsetsController.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                windowInsetsController.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            window.decorView.systemUiVisibility = hideSystemBars()
        }
    }

    open fun showKeyboard(view: View?) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    open fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(window.decorView.rootView.windowToken, 0)
    }
    fun hideSoftKeyboard() {
        val v = currentFocus
        if (v != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(v.applicationWindowToken, 0)
            v.clearFocus()
        }
    }
    fun handleBackPress() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate();
        }

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
    protected fun addDispose(disposable: Disposable?) {
        disposable?.let {
            compositeDisposable.add(disposable)
        }

    }
    open fun addFragment(
        fragment: Fragment,
        viewId: Int = android.R.id.content,
        addToBackStack: Boolean = true
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.slide_out
        )
        transaction.add(viewId, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
    open fun hideFragment(
        fragment: Fragment,
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.slide_out
        )
        transaction.hide(fragment)
        transaction.commit()
    }
    open fun addFragment(
        fragment: Fragment,
        viewId: Int = android.R.id.content,
        addToBackStack: Boolean = true,
        hideBottomBar: Boolean
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.slide_out
        )
        if (hideBottomBar) {
            findViewById<FrameLayout>(viewId).visibility = View.GONE
        }
        transaction.add(viewId, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }


    open fun replaceFragment(
        fragment: Fragment,
        viewId: Int = android.R.id.content,
        addToBackStack: Boolean = true
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(viewId, fragment)
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.slide_out
        )
        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commit()
    }

    fun isAPI33OrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
    }

    fun goToSetting(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri
        context.startActivity(intent)
        BaseFragment.isGoToSetting = true
    }


    val permissions =
        arrayOf(
            Manifest.permission.CAMERA, if (isAPI33OrHigher()) {
                Manifest.permission.READ_MEDIA_IMAGES
            } else {
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, Manifest.permission.POST_NOTIFICATIONS
        )

    val permissionsForUsedApp =
        arrayOf(
            Manifest.permission.CAMERA, if (isAPI33OrHigher()) {
                Manifest.permission.READ_MEDIA_IMAGES
            } else {
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            }
        )

    fun loadImage(url: Any, view: ImageView) {
        Glide.with(this).load(url).into(view)
    }

    var permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
            val allPermissionGranted = permissionsForUsedApp.all {
                ContextCompat.checkSelfPermission(
                    this,
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }

            if (!allPermissionGranted) {
                goToSetting(this)
            }
        }


    fun AllPermissionsGranted(context: Context): Boolean {
        for (permission in permissionsForUsedApp) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }

    protected fun showFullscreen(on: Boolean) {
        onFullscreen = on
        if (on)
            setFullscreen()
    }
    protected fun showOnLockscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON)
        }
    }

    protected fun dismissKeyguard() {
        with(getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                requestDismissKeyguard(this@BaseActivity, null)
            }
        }
    }

}

