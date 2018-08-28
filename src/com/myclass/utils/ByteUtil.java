package com.myclass.utils;

import org.apache.log4j.Logger;

public class ByteUtil {

	public static Logger LOG = Logger.getLogger(ByteUtil.class);

	private ByteUtil() {
	}

	/**
	 * 
	 * @param bytE
	 * @return
	 */
	// byteAmount method converts bytes to KB, MB...
	public static String byteAmount(long bytE) {
		LOG.info("Entering byteAmount method.");
		String byteString;
		if (bytE < 1024) {
			byteString = bytE + " byte";
		} else if (bytE / 1024 < 1024) {
			byteString = (double) (bytE / 1024) + " KB";
		} else if (bytE / 1024 / 1024 < 1024) {
			byteString = (double) (bytE / 1024 / 1024) + " MB";
		} else {
			byteString = (double) (bytE / 1024 / 1024 / 1024) + " GB";
		}
		return byteString;

	}

}
