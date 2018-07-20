package com.tr.cdb.aws.java.lambda.pojo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloPojo {
	
	public static ResponseClass myHandler(RequestClass request, Context context)
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		
		LambdaLogger logger=context.getLogger();
		//logger.log("Birthday:"+request.getBirthdate().getTime());
		
		
		//logger.log("Request -- Name:"+request.getName()+"|Age:"+request.getAge()+"|Birthday:"+f.format(request.getBirthdate()));
		
		ResponseClass response=new ResponseClass();
		response.passed=true;
		response.score=100;
		response.execdate=new Date();
		logger.log("Response -- Is_passed:"+response.isPassed()+"|score:"+response.getScore());
		
		return response;
	}

}
