package br.com.luizcampos.deepink.ui.bettershop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luizcampos.deepink.R
import br.com.luizcampos.deepink.ui.base.auth.BaseAuthFragment

abstract class BetterShopFragment() : BaseAuthFragment(){

    //override val layout = R.layout.fragment_better_shop
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_better_shop, container, false)
    }
}