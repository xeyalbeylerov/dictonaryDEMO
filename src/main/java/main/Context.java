/*
 * Copyright (c) 2020.
 * xeyalbeylerov
 */

package main;

import bean.Config;
import file.FileUtility;

public class Context {
    private static FileUtility<Config> fileUtility=new FileUtility<>();

    public static FileUtility<Config> getFileUtility() {
        return fileUtility;
    }
}
