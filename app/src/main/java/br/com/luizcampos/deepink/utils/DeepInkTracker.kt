package br.com.luizcampos.deepink.utils

import android.app.Activity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object DeepInkTracker {

    fun trackEvent(activity: Activity, bundle: Bundle) {
        val mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity)
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}