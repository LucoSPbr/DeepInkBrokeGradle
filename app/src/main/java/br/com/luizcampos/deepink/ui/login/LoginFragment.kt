package br.com.luizcampos.deepink.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import br.com.luizcampos.deepink.R



class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var containerLogin: LinearLayout
    private lateinit var tvSubTitleLogin: TextView
    private lateinit var tvNewAccount: TextView
    private lateinit var tvResetPassword: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        startLoginAnimation()
    }
    private fun setUpView(view: View) {
        containerLogin = view.findViewById(R.id.containerLogin)
        tvSubTitleLogin = view.findViewById(R.id.tvSubTitleLogin)
        tvNewAccount = view.findViewById(R.id.tvNewAccount)
        tvResetPassword= view.findViewById(R.id.tvResetPassword)
    }
    private fun startLoginAnimation() {
        val anim = AnimationUtils.loadAnimation(context, R.anim.anim_form_login)
        containerLogin.startAnimation(anim)
        tvSubTitleLogin.startAnimation(anim)
        tvNewAccount.startAnimation(anim)
        tvResetPassword.startAnimation(anim)
    }
}