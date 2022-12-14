package com.hazael.hiltdaggerexample.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import javax.inject.Qualifier

/**
 *
 *
 * @author Lior Hazael
 */

class AuthInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		TODO("Not yet implemented")
	}
}


class OtherInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		TODO("Not yet implemented")
	}
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@AuthInterceptorOkHttpClient
	@Provides
	fun provideAuthInterceptorOkHttpClient(
		authInterceptor: AuthInterceptor
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(authInterceptor)
			.build()
	}

	@OtherInterceptorOkHttpClient
	@Provides
	fun provideOtherInterceptorOkHttpClient(
		otherInterceptor: OtherInterceptor
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(otherInterceptor)
			.build()
	}
}

