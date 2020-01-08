package com.epn.volleyejemploapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.volley.toolbox.Volley

import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.Request
import com.android.volley.Response




class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView= findViewById(R.id.txtMensaje)

    }

    fun onClickConsultarString(view: View){
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        val stringRequest = StringRequest(Request.Method.GET, url, object : Response.Listener<String> {

            override fun onResponse(response: String) {
                textView.setText("Response is: " + response.substring(0, 500))
            }
        }, object : Response.ErrorListener {


            override fun onErrorResponse(error: VolleyError) {
                textView.setText("That didn't work!")
            }


        })
        queue.add(stringRequest)


    }


    fun onClickConsultarJson(view: View){

 
    }


}
