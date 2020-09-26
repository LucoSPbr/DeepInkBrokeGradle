package br.com.luizcampos.deepink.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.luizcampos.deepink.R
import br.com.luizcampos.deepink.models.RequestState
import br.com.luizcampos.deepink.models.dashboardmenu.DashboardItem
import br.com.luizcampos.deepink.ui.base.BaseFragment
import br.com.luizcampos.deepink.ui.login.LoginFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override val layout = R.layout.fragment_home
    lateinit var homeViewModel: HomeViewModel
    private lateinit var rvHomeDashboard: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        startLoginAnimation()
        registerObserver()
        registerBackPressedAction()
    }
    private fun setUpView(view: View) {
        rvHomeDashboard = view.findViewById(R.id.rvHomeDashboard)
    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun registerObserver() {
        homeViewModel.menuState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Loading -> {
                    showLoading()
                }
                is RequestState.Success -> {
                    hideLoading()
                    setUpMenu(it.data)
                }
                is RequestState.Error -> {
                    hideLoading()
                }
            }
        })

        homeViewModel.userNameState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Loading -> {
                    tvHomeHelloUser.text = "Carregando ..."
                }
                is RequestState.Success -> {
                    tvHomeHelloUser.text =
                        String.format(homeViewModel.dashboardMenu?.title ?: "", it.data)
                    tvSubTitleSignUp.text = homeViewModel.dashboardMenu?.subTitle
                }
                is RequestState.Error -> {
                    tvHomeHelloUser.text = "Bem-vindo"
                    tvSubTitleSignUp.text = homeViewModel.dashboardMenu?.subTitle
                }
            }
        })

        homeViewModel.logoutState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Loading -> {
                    showLoading()
                }
                is RequestState.Success -> {
                    hideLoading()
                    findNavController().navigate(R.id.login_nav_graph)
                }
                is RequestState.Error -> {
                    hideLoading()
                    showMessage(it.throwable.message)
                }
            }
        })
    }

    private fun setUpMenu(items: List<DashboardItem>) {
        rvHomeDashboard.adapter = HomeListAdapter(items, this::clickItem)
    }

    private fun clickItem(item: DashboardItem) {
        item.onDisabledListener.let {
            it?.invoke(requireContext())
        }
        if (item.onDisabledListener == null) {
            when (item.feature) {
                "SIGN_OUT" -> {
                    homeViewModel.signOut()
                }
                else -> {
                    showMessage(item.label)
                }
            }
        }
    }
}