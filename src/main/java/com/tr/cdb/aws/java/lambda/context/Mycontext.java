package com.tr.cdb.aws.java.lambda.context;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class Mycontext implements RequestStreamHandler {
	
	//The input payload must be valid JSON but the output stream does not carry such a restriction. Any bytes are supported.
	//input 必须是json
	public void handleRequest(InputStream is, OutputStream os, Context context) throws IOException
	{
		
		
		StringBuffer sbResponse=new StringBuffer();
		
		LambdaLogger logger = context.getLogger();
		
		StringBuffer function_name=new StringBuffer("Function Name: ").append(context.getFunctionName()).append("\n");
		logger.log(function_name.toString());
		sbResponse.append(function_name);
		
		StringBuffer function_clientcontext=new StringBuffer("Function Client Context: ").append(context.getClientContext()).append("\n");
		logger.log(function_clientcontext.toString());
		sbResponse.append(function_clientcontext);

		StringBuffer max_mem=new StringBuffer("Max mem allocated: ").append(context.getMemoryLimitInMB()).append("\n");
		logger.log(max_mem.toString());
		sbResponse.append(max_mem);
		
		StringBuffer time_remaining=new StringBuffer("Time remaining in milliseconds: ").append(context.getRemainingTimeInMillis()).append("\n");
		logger.log(time_remaining.toString());
		sbResponse.append(time_remaining);
		
		StringBuffer cloudwatch_stream=new StringBuffer("CloudWatch log stream name: ").append(context.getLogStreamName()).append("\n");
		logger.log(cloudwatch_stream.toString());
		sbResponse.append(cloudwatch_stream);		
		
		StringBuffer cloudwatch_group=new StringBuffer("CloudWatch log group name: ").append(context.getLogGroupName()).append("\n");
		logger.log(cloudwatch_group.toString());
		sbResponse.append(cloudwatch_group);		
		
		sbResponse.append("InputStream: ");		
		
		int bufferSize = 1024;
		char[] buffer = new char[bufferSize];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(is, "UTF-8");
		for (; ; ) {
		    int rsz = in.read(buffer, 0, buffer.length);
		    if (rsz < 0)
		        break;
		    out.append(buffer, 0, rsz);
		}
		
		sbResponse.append(out).append("\n");
		
		System.getenv();
		sbResponse.append("Environment variables (if any): ");	
			
		for (Entry<String,String> pair : System.getenv().entrySet())
		{
			sbResponse.append(pair.getKey()).append("--->").append(pair.getValue()).append("\n");
		}
		
		OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");

		osw.write(sbResponse.toString());
		osw.flush();
	}
}
