package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String Account_PAGE_TITLE = "My Account";
	public static final int Account_PAGE_HEADERS_COUNT = 4;

	public static final List<String> EXPECTED_ACCOUNT_HEADERS_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletters");

	// Default time out value
	public static final byte SHORT_TIME_OUT = 5;
	public static final byte MEDIUM_TIME_OUT = 10;
	public static final byte LONG_TIME_OUT = 15;
	
	
	//final 
	
//	if added with a method the it cant be override
//	if added with variable the we cant re intialize it
//	if added with class the we cant inherit it.
	
	

}
