package br.com.luizcampos.deepink.utils.featuretoggle

data class FeatureConfig(
    val releasedVersion: Int,
    val minimumVersion: Int,
    val status: FeatureToggleState
)
