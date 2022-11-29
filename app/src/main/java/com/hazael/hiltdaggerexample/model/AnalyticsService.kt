package com.hazael.hiltdaggerexample.model

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

/**
 *
 *
 * @author Lior Hazael
 */
interface AnalyticsService{
	fun analyticsMethods()
}

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class AnalyticsServiceImpl @Inject constructor(
	@AuthInterceptorOkHttpClient private val okHttpClient: OkHttpClient // As a dependency of a constructor-injected class.
) : AnalyticsService {

	override fun analyticsMethods() {
		TODO("Not yet implemented")
	}

}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule1 {

	@Binds
	abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService

}

// @Provides-injected, when constructor injection is not possible
// if you don't own the class because it comes from an external library.
@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule2 {

	@Provides
	fun provideAnalyticsService(
		@AuthInterceptorOkHttpClient okHttpClient: OkHttpClient // As a dependency of another class.
	): AnalyticsService {
		return Retrofit.Builder()
			.baseUrl("https://example.com")
			.build()
			.create(AnalyticsService::class.java)
	}
}