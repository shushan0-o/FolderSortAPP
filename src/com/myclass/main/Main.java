package com.myclass.main;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;

import com.myclass.common.FoldersSort;

public class Main {

	public static void main(String[] args) {

		BasicConfigurator.configure();

		try {
			if (args.length == 1) {
				FoldersSort.sortDirFoldersBySize(args[0]);
			} else {
				System.out.println("You missed argument");
				System.exit(-1);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
