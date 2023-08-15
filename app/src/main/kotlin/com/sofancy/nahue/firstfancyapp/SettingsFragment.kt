package com.sofancy.nahue.firstfancyapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.lightvessel.core.injection.inject
import com.lightvessel.core.preferences.DelegatedPreference
import com.lightvessel.core.preferences.PreferencesManager

class SettingsFragment: BaseFragment() {
    override val layout = R.layout.fragment_settings
    override val containerId = R.id.main_content
    var saludo by DelegatedPreference("Prussia", {fragActivity()})
    val editSaludo:EditText by inject(R.id.saludo_settings)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editSaludo.setText(saludo)
        editSaludo.oneWayBinding { saludo = it }
    }

    fun EditText.oneWayBinding( receiver: (String)->Unit ){
        this.addTextChangedListener(object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                receiver.invoke(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}

/**
 * Created by nahue on 23/07/15.
 */
