package com.amgen.getResponse.utility;

public class GetResponseLoggerFactory
{
	private static GetResponseLoggerFactory logFactory; 

	public static GetResponseLog getLog(String name)
	{
		return new GetResponseLog (name);
	}

	public static GetResponseLog getLog(Class cl)
	{
		return new GetResponseLog (cl);
	}
	
	public static GetResponseLoggerFactory getInstance() {
		if (logFactory == null) {
			return new GetResponseLoggerFactory();

		} else {
			return logFactory;
		}

	}
}
