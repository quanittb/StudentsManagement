package com.example.studentsmanagement.lib



object SharedPreferenceUtils {
    private const val FIRST_OPEN_APP = "FIRST_OPEN_APP"
    private const val LANGUAGE = "LANGUAGE"
    private const val IS_SIGN_IN = "IS_SIGN_IN"



    var firstOpenApp: Boolean
        get() = sharedPreferencesManager.getValueBool(FIRST_OPEN_APP, true)
        set(value) = sharedPreferencesManager.setValueBool(FIRST_OPEN_APP, value)

    var languageCode: String?
        get() =  sharedPreferencesManager.getValue(LANGUAGE, null)
        set(value) = sharedPreferencesManager.setValue(LANGUAGE, value)
    var isSignIn: Boolean
        get() = sharedPreferencesManager.getValueBool(IS_SIGN_IN, false)
        set(value) = sharedPreferencesManager.setValueBool(IS_SIGN_IN, value)

}
