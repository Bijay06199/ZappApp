package com.example.zappapp.base

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.zappapp.BR

abstract class BaseActivity<
        DATA_BINDING : ViewDataBinding,
        VIEW_MODEL : BaseViewModel> :
    AppCompatActivity() {

    protected lateinit var viewDataBinding: DATA_BINDING
    protected var mViewModel: VIEW_MODEL? = null
    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        performDataBinding()
        initObservers()

    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = mViewModel ?: getViewModel()
        viewDataBinding.apply {
            setVariable(getBindingVariable(), mViewModel)
            lifecycleOwner = this@BaseActivity
            executePendingBindings()
        }

    }

    private fun initObservers() {

    }



    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     * @return view model instance
     */
    abstract fun getViewModel(): VIEW_MODEL

    /**
     * Override for set binding variable
     * @return variable id
     */
    open fun getBindingVariable(): Int = BR.viewModel



}