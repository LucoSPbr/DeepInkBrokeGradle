package br.com.luizcampos.deepink.models

import com.google.firebase.firestore.Exclude

data class NewUser(
    var username: String? = null,
    var email: String? = null,
    var phone: String? = null,
    @Exclude var password: String? = null
)