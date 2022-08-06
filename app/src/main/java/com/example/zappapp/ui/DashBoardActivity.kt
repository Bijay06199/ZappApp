package com.example.zappapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.zappapp.R
import com.example.zappapp.base.BaseActivity
import com.example.zappapp.databinding.ActivityDashboardBinding
import com.example.zappapp.ui.model.Photo
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashBoardActivity : BaseActivity<ActivityDashboardBinding, DashBoardViewModel>(),SavedAdapter.OnItemClicklistener {

    override fun getLayoutId(): Int = R.layout.activity_dashboard


    override fun getViewModel(): DashBoardViewModel {
        val viewModel: DashBoardViewModel by viewModel()
        return viewModel
    }


    lateinit var savedAdapter: SavedAdapter
    var photosList=ArrayList<Photo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initRecyclerView()


    }

    private fun initRecyclerView() {

        with(getViewModel()){
            with(viewDataBinding){
                getAllPhoto()

                getSavedPhotoItem.observe(this@DashBoardActivity){

                    savedAdapter = SavedAdapter(it,this@DashBoardActivity,this@DashBoardActivity)

                    recyclerViewItem.adapter=savedAdapter

                }
            }


        }

    }

    private fun initViews() {

        with(viewDataBinding) {

            btnSave.setOnClickListener {
                with(viewModel!!) {

                    savePhoto(  // insert the photo items
                        Photo(
                            etUserTitle.text.toString(),
                            etUserURL.text.toString(),
                            null,
                            null

                        )
                    )

                }

                startActivity(Intent(this@DashBoardActivity,DashBoardActivity::class.java))
                etUserTitle.setText("")
                etUserURL.setText("")
            }


        }
    }

    override fun onEditClick(position: Int,items:List<Photo>) {
        with(getViewModel()){
            var photo=Photo(
                "",
                "",
                "",
                null
            )
            updatePhoto(photo) // passing the parameters to update .It is just for example

        }
        savedAdapter.notifyItemChanged(position)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDeleteClick(position: Int, items:List<Photo>) { // delete the specific items in accordance to their id

        with(getViewModel()) {
        if (!viewDataBinding.recyclerViewItem.isComputingLayout && viewDataBinding.recyclerViewItem.scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            deletePhoto(items[position].id!!)
            viewDataBinding.recyclerViewItem.adapter?.notifyItemRemoved(position)
        }
            startActivity(Intent(this@DashBoardActivity,DashBoardActivity::class.java))



        }
    }



}