package com.example.zappapp.di

import com.example.zappapp.ui.DashBoardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel { DashBoardViewModel(get()) }
}