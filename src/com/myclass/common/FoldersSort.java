/**
 * 
 */
package com.myclass.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import com.myclass.utils.ByteUtil;
import com.myclass.utils.DirChecingActions;

/**
 * @author SHUSHAND
 *
 */
public class FoldersSort {
	public static Logger LOG = Logger.getLogger(FoldersSort.class);
	private static File dir;
	private static DirChecingActions obj;

	/**
	 * 
	 * @param pathSource
	 * @throws IOException
	 */
	public static void sortDirFoldersBySize(String pathSource) throws IOException {
		LOG.info("Entering sortDirFoldersBySize metod for " + pathSource);
		List<File> list = new ArrayList<File>();
		if (pathSource != null && !pathSource.equals("")) {
			LOG.info("Source isn't empty or equally null");
			dir = new File(pathSource);
			obj = new DirChecingActions(dir);
			if (obj.isCheckingPassed()) {

				// find dir folders & add to list
				for (File fileArr : dir.listFiles()) {
					if (fileArr.isDirectory()) {
						list.add(fileArr);
					}
				}
				// sort folders in list by size
				Collections.sort(list, new Comparator<File>() {
					public int compare(File f1, File f2) {
						Long f1Size = 0L;
						Long f2Size = 0L;
						try {
							f1Size = Files.walk(f1.toPath()).mapToLong(p -> p.toFile().length()).sum();
							f2Size = Files.walk(f2.toPath()).mapToLong(p -> p.toFile().length()).sum();

						} catch (IOException e) {
							e.printStackTrace();
						}
						return Long.compare(f1Size, f2Size);
					}
				});
				// create SortedFolderNames.txt file
				FileWriter fw = new FileWriter("SortedFolderNames.txt");

				// write sorted folders names&sizes in SortedFolderNames.txt
				for (File folder : list) {
					fw.write(folder.getName() + "  "
							+ ByteUtil.byteAmount(Files.walk(folder.toPath()).mapToLong(p -> p.toFile().length()).sum())
							+ "\r\n");
				}
				fw.close();

			}
		} else {
			LOG.error("ERROR: Adress line is empty or equally null");

		}
	}
}