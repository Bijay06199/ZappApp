package com.example.zappapp.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<
        DATA_BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel> : Fragment() {

    protected lateinit var viewDataBinding: DATA_BINDING
    protected var mViewModel: VIEW_MODEL? = null
    private var progressDialog: Dialog? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performDataBinding(inflater, container)
        return viewDataBinding.root
    }

    private fun performDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        this.mViewModel = mViewModel ?: getViewModel()

        viewDataBinding.apply {
            setVariable(getBindingVariable(), mViewModel)
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
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
    abstract fun getBindingVariable(): Int




}