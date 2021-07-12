package com.loanwalle.loanwallecollection.ui.main.view.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.loanwalle.loanwallecollection.R
import com.loanwalle.loanwallecollection.data.model.getFollowupCollection.GetFollowupRequest
import com.loanwalle.loanwallecollection.data.model.newPassword.NewPasswordRequestBodies
import com.loanwalle.loanwallecollection.data.model.upDateFollowup.UpdateFollowupRequestBodies
import com.loanwalle.loanwallecollection.data.repository.AppRepository
import com.loanwalle.loanwallecollection.ui.base.ViewModelProviderFactory
import com.loanwalle.loanwallecollection.ui.main.viewmodel.GetFollowupViewModel
import com.loanwalle.loanwallecollection.ui.main.viewmodel.NewPasswordViewModel
import com.loanwalle.loanwallecollection.ui.main.viewmodel.UpdateCollectionViewModel
import com.loanwalle.loanwallecollection.utils.Resource
import com.loanwalle.loanwallecollection.utils.errorSnack
import kotlinx.android.synthetic.main.activity_document.*
import kotlinx.android.synthetic.main.activity_resest.*
import kotlinx.android.synthetic.main.activity_residance.*

class ResidanceActivity : AppCompatActivity() {
    lateinit var getFollowupViewModel: GetFollowupViewModel
    lateinit var updateCollectionViewModel: UpdateCollectionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_residance)

        init1()
//        verifyClick1()

        back_residance.setOnClickListener{
            onBackPressed()
        }


    }

    private fun init1() {
        val repository = AppRepository()
        val factory = ViewModelProviderFactory(application, repository)
        updateCollectionViewModel = ViewModelProvider(this, factory).get(UpdateCollectionViewModel::class.java)
    }
    private fun init() {
        val repository = AppRepository()
        val factory = ViewModelProviderFactory(application, repository)
        getFollowupViewModel = ViewModelProvider(this, factory).get(GetFollowupViewModel::class.java)
    }
    fun verifyClick() {
        val followup_id = 1
        val lead_id = 2457
        val user_id = 44
        val company_id = 2
        val product_id = 2
        if (followup_id!= null && lead_id!= null && user_id!=null && company_id !=null && product_id !=null) {
            val body = GetFollowupRequest.GetFollowupRequest(
                followup_id ,
                company_id.toString(),
                lead_id.toString(),
                user_id,
                product_id

            )

            getFollowupViewModel.getCollec(body)

            getFollowupViewModel.getCollec.observe(this, Observer { event ->
                event.getContentIfNotHandled()?.let { response ->
                    when (response) {
                        is Resource.Success -> {
                            hideProgressBar()

                            response.data?.let { verifyResponse ->
                                val message:String= verifyResponse.message
                                Log.e("Resopncelogin",message);
                                if (message.equals("success")&&verifyResponse.status.equals("200"))
                                {
                                    //ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
                                }
                                else
                                {
                                    ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
                                }
                            }
                        }

                        is Resource.Error -> {
                            hideProgressBar()
                            response.message?.let { message ->
                                ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
                            }
                        }
                        is Resource.Loading -> {
                            showProgressBar()
                        }
                    }
                }
            })
        }

    }

//    fun verifyClick1() {
//        val followup_id = 1
//        val paid_amount = 2457
//        val followup_remark = ""
//        val followup_date = 2
//        val updated_by = 2
//        val total_distance = ""
//        val executive_ending_latitude = ""
//        val executive_ending_longitude = ""
//        val followup_ended_at = ""
//        if (followup_id!= null && paid_amount!= null &&
//            followup_remark!=null && followup_date !=null &&
//            updated_by !=null && total_distance !=null
//            &&executive_ending_latitude != null && executive_ending_longitude != null
//            && followup_ended_at !=null) {
//            val body = UpdateFollowupRequestBodies.UpdateFollowupRequest(
//                followup_id.toString() ,
//                paid_amount.toString(),
//                followup_remark,
//                followup_date.toString(),
//                updated_by.toString(),
//                total_distance,
//                executive_ending_latitude,
//                executive_ending_longitude,
//                followup_ended_at
//            )
//
//
//
//            updateCollectionViewModel.updateCollec(body)
//
//            updateCollectionViewModel.upDateCollec.observe(this, Observer { event ->
//                event.getContentIfNotHandled()?.let { response ->
//                    when (response) {
//                        is Resource.Success -> {
//                            hideProgressBar()
//
//
//                            response.data?.let { verifyResponse ->
//                                val message:String= verifyResponse.message
//                                Log.e("Resopncelogin",message);
//                                if (message.equals("Data updated Successfully")&&verifyResponse.status.equals("200"))
//                                {
//                                    ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
//
//                                }
//                                else
//                                {
//                                    ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
//                                }
//
//
//                            }
//                        }
//
//                        is Resource.Error -> {
//                            hideProgressBar()
//                            response.message?.let { message ->
//                                ppprrrooggess.errorSnack(message, Snackbar.LENGTH_LONG)
//                            }
//                        }
//
//                        is Resource.Loading -> {
//                            showProgressBar()
//                        }
//                    }
//                }
//            })
//        }
//
//    }

    fun hideProgressBar() {
        ppprrrooggess.visibility = View.GONE
    }
    fun showProgressBar() {
        ppprrrooggess.visibility = View.VISIBLE
    }
}