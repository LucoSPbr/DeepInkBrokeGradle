package br.com.luizcampos.deepink.ui.terms

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import br.com.luizcampos.deepink.R
import br.com.luizcampos.deepink.ui.base.BaseFragment
import br.com.luizcampos.deepink.utils.firebase.RemoteConfigKeys
import br.com.luizcampos.deepink.utils.firebase.RemoteConfigUtils

class TermsFragment : BaseFragment() {
    override val layout = R.layout.fragment_terms
    private lateinit var wvTerms: WebView
    private lateinit var ivBack: ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wvTerms = view.findViewById(R.id.wvTerms)
        ivBack = view.findViewById(R.id.ivBack)
        ivBack.setOnClickListener {
            activity?.onBackPressed()
        }
        val termsUrl = RemoteConfigUtils.getFirebaseRemoteConfig()
            .getString(RemoteConfigKeys.TERMS_URL)
        wvTerms.webViewClient = DeepInkWebViewClients(this)
        wvTerms.loadUrl(termsUrl)
    }
}

class DeepInkWebViewClients(private val baseFragment: BaseFragment) : WebViewClient()
{
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }
    override fun onPageFinished(view: WebView, url: String) {
        super.onPageFinished(view, url)
        baseFragment.hideLoading()
    }
    init {
        baseFragment.showLoading()
    }
}