package com.tr.cdb.aws.java.lambda.event.sns;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;


public class SNSEventHandler {
	public String mySNSEventHandler(SNSEvent snsmsg, Context context)
	{
		System.out.println("log stream = "+context.getLogStreamName()+", log group = "+ context.getLogGroupName());
		LambdaLogger logger=context.getLogger();
		logger.log("Received event:"+snsmsg.toString() );
		logger.log("From SNS:"+snsmsg.getRecords().get(0).getSNS().getMessage());
		
		return String.valueOf(snsmsg.getRecords().get(0).getSNS().getMessage());
	}
}
