package com.tr.cdb.aws.java.lambda.log;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class HelloLog4J {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(HelloLog4J.class);

	public String myHandler(String name, Context context) {

		LoggerContext logcontext = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		File file = new File(HelloLog4J.class.getResource("log4j2.xml").getFile());

		// this will force a reconfiguration
		logcontext.setConfigLocation(file.toURI());

		// System.out: One log statement but with a line break (AWS Lambda writes two
		// events to CloudWatch).
		System.out.println("log data from stdout \n this is continuation of system.out");

		// System.err: One log statement but with a line break (AWS Lambda writes two
		// events to CloudWatch).
		System.err.println("log data from stderr. \n this is a continuation of system.err");

		logger.error("log data from log4j err. \n this is a continuation of log4j.err");

		// Return will include the log stream name so you can look
		// up the log later.
		return String.format("Hello %s. log stream = %s, log group = %s", name, context.getLogStreamName(), context.getLogGroupName());
	}
}