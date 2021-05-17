package com.loanwalle.loanwallecollection.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loanwalle.loanwallecollection.Fragment.AddressFragment
import com.loanwalle.loanwallecollection.R
import com.loanwalle.loanwallecollection.databinding.ActivityLoanDetailBinding

class LoanDetailActivity : AppCompatActivity() {

    var binding:ActivityLoanDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoanDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.currentAddText.setOnClickListener{
          var inten = Intent(this,Recovery_Address::class.java)
            startActivity(inten)
        }



//        binding!!.officeAddText.setOnClickListener{
//            var intent = Intent(this,Recovery_Address::class.java)
//            startActivity(intent)
//        }
//        binding!!.permanentAddText.setOnClickListener{
//            var intent = Intent(this,Recovery_Address::class.java)
//            startActivity(intent)
//        }
//
//        binding!!.preferdeAddText.setOnClickListener{
//            var intent1 = Intent(this,Recovery_Address::class.java)
//            startActivity(intent1)
//        }

        binding!!.loanDetailText.setOnClickListener{
            var inte = Intent(this,LoanActivity::class.java)
            startActivity(inte)
        }

        binding!!.documents.setOnClickListener{
            var i = Intent(this,DocumentActivity::class.java)
            startActivity(i)
        }


    }
}