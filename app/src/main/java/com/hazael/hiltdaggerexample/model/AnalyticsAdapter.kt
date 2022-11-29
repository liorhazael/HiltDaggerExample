package com.hazael.hiltdaggerexample.model

import javax.inject.Inject

/**
 *
 *
 * @author Lior Hazael
 */
class AnalyticsAdapter @Inject constructor(
	private val service: AnalyticsService
) {
}