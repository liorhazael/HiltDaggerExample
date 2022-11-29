package com.hazael.hiltdaggerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hazael.hiltdaggerexample.model.AnalyticsAdapter
import com.hazael.hiltdaggerexample.model.AuthInterceptorOkHttpClient
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	@Inject lateinit var analytics: AnalyticsAdapter

	@AuthInterceptorOkHttpClient // At field injection.
	@Inject lateinit var okHttpClient: OkHttpClient

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

}