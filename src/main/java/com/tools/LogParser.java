package com.tools;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;

public class LogParser {
    static final String filePath = "/Users/qiaor/Desktop/script/log1";
    //http://system.duorongcf.com/memberFundsLog/memberFundsLogList.do
    static final String URI = "memberFundsLogList";


    public static void main(String[] args) throws IOException {
        Collection<File> files = FileUtils.listFiles(new File(filePath), fileFilter, dirFilter);

        int count = 0;
        for (File file : files) {
            System.out.println("---###---" + file.getName());

            LineIterator lineIterator = FileUtils.lineIterator(file);
            while (lineIterator.hasNext()) {
                count++;
                String line = lineIterator.next();

                if (StringUtils.contains(line, URI)) {
                    System.out.println(line);
                }
            }
        }

        System.out.println("LineCount: " + count);
    }

    static IOFileFilter fileFilter = new IOFileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".txt") || file.getName().endsWith(".log");
        }

        @Override
        public boolean accept(File dir, String name) {
            return true;
        }
    };

    static IOFileFilter dirFilter = new IOFileFilter() {
        @Override
        public boolean accept(File file) {
            return true;
        }

        @Override
        public boolean accept(File dir, String name) {
            return true;
        }
    };

}
