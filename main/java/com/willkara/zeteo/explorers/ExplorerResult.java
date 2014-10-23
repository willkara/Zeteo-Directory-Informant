/*
 * Copyright (C) 2014 willkara
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.willkara.zeteo.explorers;

import com.willkara.zeteo.filetypes.impl.BaseFileType;
import com.willkara.zeteo.reporters.impl.FileDirectoryReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public class ExplorerResult {

    private static ConcurrentHashMap<String, List<BaseFileType>> fileCounter = new ConcurrentHashMap<>();

    private int totalFileCount = 0;
    private String[] fileTypeArray;
    private long totalSizeCount = 0;

    /**
     * Explorer Collection Constructor
     *
     * @param explorerMap The CincurrentHashMap that contains the file types and counts
     * from the Explorer Class
     */
    public ExplorerResult(ConcurrentHashMap<String, List<BaseFileType>> explorerMap) {
        fileCounter = explorerMap;
        fileTypeArray = new String[fileCounter.entrySet().size()];
        int count = 0;
        //Print all values stored in ConcurrentHashMap instance
        for (Map.Entry<String, List<BaseFileType>> e : fileCounter.entrySet()) {
            totalFileCount += e.getValue().size();
            for (BaseFileType bft : e.getValue()) {
                totalSizeCount += bft.getFileSize();
            }
            fileTypeArray[count] = e.getKey();
            count++;
        }
    }

    public FileDirectoryReport getReport() {

        return new FileDirectoryReport(this);
    }

    /**
     * Gets the total size of all of the files of the specified type
     *
     * @param extension The file extension you wish to use.
     * @return Total size of all files for specified extension in bytes.
     */
    public long getFileTypeTotalSize(String extension) {
        long size = 0;

        List<BaseFileType> bftList = fileCounter.get(extension);
        for (BaseFileType bft : bftList) {

            size += bft.getFileSize();

        }

        return size;

    }

    /**
     * @return the fileCounter
     */
    public ConcurrentHashMap<String, List<BaseFileType>> getFileCounter() {
        return fileCounter;
    }

    /**
     * Returns the most common file type.
     *
     * @return A String standing for the most common file type.
     */
    public String getMostCommonFileType() {

        int counter = 0;
        String type = null;

        Iterator it = fileCounter.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            int listSize = ((List<BaseFileType>) pairs.getValue()).size();
            if (listSize > counter) {
                counter = listSize;
                type = pairs.getKey().toString();
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return type;
    }

    /**
     * Get the list of files of the most common file type.
     *
     * @return A list containing the files.
     */
    public List<BaseFileType> getListOfMostCommonFile() {

        return fileCounter.get(getMostCommonFileType());

    }

    /**
     * @return the fileTypeArray
     */
    public String[] getFileTypeArray() {
        return fileTypeArray;
    }

    /**
     * Does the specified file type exist?
     *
     * @param ext The extension you wish to check.
     * @return True if the filetype exists in the current map.
     */
    public boolean doesFileTypeExist(String ext) {
        return Arrays.asList(getFileTypeArray()).contains(ext);

    }

    /**
     * Get the list of files for the specified extension.
     *
     * @param extension The extension you wish to search for.
     * @return
     */
    public List<BaseFileType> getFilesForExtension(String extension) {

        if (doesFileTypeExist(extension)) {
            return fileCounter.get(extension);
        } else {
            return null;
        }

    }

    /**
     * Get the amount of files for a specified extension
     *
     * @param extension The extension you wish to search for.
     * @return The amount of files for a certain extension
     */
    public int getCountOfFilesForExtension(String extension) {

        if (doesFileTypeExist(extension)) {
            return fileCounter.get(extension).size();
        } else {
            return 0;
        }

    }

    /**
     * Gives you the percentage of a file type compared to the total amount of
     * files. i.e. What is the percentage of .java files in this directory.
     *
     * @param extension The extension you wish to search for.
     * @return The percentage for the specified file type.
     */
    public double getFileTypePercentage(String extension) {

        if (doesFileTypeExist(extension)) {
            return (fileCounter.get(extension).size() * 100.00) / totalFileCount;
        } else {
            return 0;
        }

    }

    /**
     * Returns a list containing JUST the file names for the specified extention
     *
     * @param extension The extension you wish to search for.
     * @return List<String> containing the names of the files.
     */
    public List<String> getFileNamesForExtension(String extension) {

        if (doesFileTypeExist(extension)) {
            List<BaseFileType> bftList = fileCounter.get(extension);
            List<String> nameList = new ArrayList<>();

            for (BaseFileType bft : bftList) {
                nameList.add(bft.getFileName());
            }
            return nameList;
        } else {
            return null;
        }
    }

    /**
     * @return the totalFileCount
     */
    public int getTotalFileCount() {
        return totalFileCount;
    }

    /**
     * @return the totalSizeCount
     */
    public long getTotalSizeCount() {
        return totalSizeCount;
    }

}
