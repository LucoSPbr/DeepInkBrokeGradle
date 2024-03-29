package br.com.luizcampos.deepink.models.dashboardmenu

import android.content.Context

data class DashboardMenu(
    val title: String,
    val subTitle: String,
    val items: List<DashboardItem>
)

data class DashboardItem(
    val feature: String,
    val image: String,
    val label: String,
    val action: DashboardAction,
    val onDisabledListener: Any,
)

data class DashboardAction(
    val deeplink: String,
    val params: HashMap<String, Any>
)