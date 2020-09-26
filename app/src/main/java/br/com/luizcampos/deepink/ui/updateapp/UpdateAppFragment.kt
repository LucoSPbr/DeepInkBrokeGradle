package br.com.luizcampos.deepink.ui.updateapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.luizcampos.deepink.R
import kotlinx.android.synthetic.main.fragment_update_app.*


class UpdateAppFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }
    private fun setUpView(view: View) {
        //btUpdateApp = view.findViewById(R.id.btUpdateApp)
        //btUpdateLater = view.findViewById(R.id.btUpdateLater)
        btUpdateApp.setOnClickListener {
            openAppInStore()
        }
        btUpdateLater.setOnClickListener {
            activity?.finish()
        }
    }

    private fun openAppInStore() {
        var intent: Intent
        val packageName = activity?.packageName
        try {
            intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$packageName"))
            startActivity(intent)
        } catch (e: android.content.ActivityNotFoundException) {
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
            startActivity(intent)
        }
    }
}