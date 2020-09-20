package br.com.luizcampos.deepink.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment
import br.com.luizcampos.deepink.R
import kotlinx.android.synthetic.main.fragment_login.*

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            val extras = FragmentNavigatorExtras(
                ivLogoApp to "logoApp",
                tvAppName to "textApp"
            )
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_splashFragment_to_login_nav_graph,
                null, null, extras)
        }, 2000)
    }
}