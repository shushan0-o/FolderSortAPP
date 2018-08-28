/**
 * 
 */
package com.myclass.utils;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author SHUSHAND
 *
 */
public class DirChecingActions {

	public static Logger LOG = Logger.getLogger(DirChecingActions.class);
	private final File dir;
	public static List<File> list;

	/**
	 * 
	 * @param pathSource
	 */
	// When creating an object, the dir is initialized
	public DirChecingActions(File pathSource) {
		dir = pathSource;
		LOG.info("Entering  constructor for " + pathSource.getName());
	}

	/**
	 * 
	 * @return
	 */
	private boolean isDirExist() {
		LOG.info("Entering  isDirExist method.");
		if (dir.exists() && dir.isDirectory()) {
			return true;
		} else {
			LOG.error("ERROR: This address is incorrect or does not contain a folder");
			return false;
		}

	}

	/**
	 * 
	 * @return
	 */
	public boolean isCheckingPassed() {
		LOG.info("Entering  isCheckingPassed method.");

		if (isDirExist()) {
			if (dir.listFiles().length > 0) {
				return true;
			} else {
				LOG.info("This folder does not contain any files");
			}
		}
		return false;
	}

}
