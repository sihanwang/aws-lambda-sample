package com.tr.cdb.aws.java.lambda.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.Context; 

public class HelloStream implements RequestStreamHandler {
	
	//The input payload must be valid JSON but the output stream does not carry such a restriction. Any bytes are supported.
	public void handleRequest(InputStream is, OutputStream os, Context context) throws IOException
	{
        int letter;
        while((letter = is.read()) != -1)
        {
            os.write(Character.toUpperCase(letter));
        }
	}

}
