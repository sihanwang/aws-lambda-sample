package com.tr.cdb.aws.java.lambda.context;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class Mycontext implements RequestStreamHandler {
	
	//The input payload must be valid JSON but the output stream does not carry such a restriction. Any bytes are supported.
	public void handleRequest(InputStream is, OutputStream os, Context context) throws IOException
	{
		LambdaLogger logger = context.getLogger();
		logger.log("Function name: " + context.getFunctionName() + "\n");
		logger.log("Function name: " + context.getClientContext() + "\n");

		Map<String, String> CustomMap = context.getClientContext().getCustom();

		CustomMap.forEach(

				(key, value) -> {
					logger.log("Custom Map Key: " + key + ", Value:" + value+"\n");
				}

		);

		Map<String, String> EnvironmentMap = context.getClientContext().getEnvironment();
		
		EnvironmentMap.forEach(

				(key, value) -> {
					logger.log("Custom Map Key: " + key + ", Value:" + value+"\n");
				}

		);

		logger.log("Max mem allocated: " + context.getMemoryLimitInMB() + "\n");
		logger.log("Time remaining in milliseconds: " + context.getRemainingTimeInMillis() + "\n");
		logger.log("CloudWatch log stream name: " + context.getLogStreamName() + "\n");
		logger.log("CloudWatch log group name: " + context.getLogGroupName() + "\n");

	}
}
