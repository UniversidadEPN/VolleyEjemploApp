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
import com.android.volley.toolbox.JsonObjectRequest



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
        val queue = Volley.newRequestQueue(this)
        val url2= "https://jsonplaceholder.typicode.com/todos/1"


        var jsObjRequest = JsonObjectRequest(Request.Method.GET, url2, null,
            Response.Listener { response -> textView.setText("Response: $response") },
            Response.ErrorListener { textView.setText("That didn't work!") })

        queue.add(jsObjRequest)


    }




}


