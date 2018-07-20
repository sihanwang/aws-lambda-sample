package com.tr.cdb.aws.java.lambda.log;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class HelloLambdaLogger {

    public String myHandler(String name, Context context) {
        
        // System.out: One log statement but with a line break (AWS Lambda writes two events to CloudWatch).
       System.out.println("log data from stdout \n this is continuation of system.out");
       
       // System.err: One log statement but with a line break (AWS Lambda writes two events to CloudWatch).
       System.err.println("log data from stderr \n this is continuation of system.err");

       LambdaLogger logger = context.getLogger();
       // Write log to CloudWatch using LambdaLogger.
       logger.log("log data from LambdaLogger \n this is continuation of logger.log");
       
       // Return will include the log stream name so you can look 
       // up the log later.
       return String.format("Hello %s. log stream = %s, log group = %s", name, context.getLogStreamName(), context.getLogGroupName());
   }
    
}
