package br.com.luizcampos.deepink.utils.firebase

import br.com.concrete.canarinho.BuildConfig
import br.com.luizcampos.deepink.R
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object RemoteConfigUtils {

    fun getFirebaseRemoteConfig(): FirebaseRemoteConfig {

        val remoteConfig = Firebase.remoteConfig

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.setConfigSettingsAsync(configSettings)
        return remoteConfig
    }

    fun fetchAndActivate(): Task<Boolean> {
        return getFirebaseRemoteConfig().fetchAndActivate()
    }
}