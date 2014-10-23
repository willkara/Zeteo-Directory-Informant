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
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.FilenameUtils;

/**
 * The main class that contains the searching methods. It's important...USE IT
 *
 * @author willkara William Karavites - wkaravites@gmail.com http://willkara.com
 */
public class Explorer {

    ExplorerOptions options;

    public Explorer(ExplorerOptions eo) {
        options = eo;
    }

    /**
     * The public facing search method. Accepts an {@link ExplorerOptions}
     * instance that contains the rules for the search.
     *
     * @param exOptions ExplorerOptions for the search method
     * @return An {@link ExplorerResult} object that contains the information
     * for the directory.
     */
    public ExplorerResult search(ExplorerOptions exOptions) {
        return new ExplorerResult(searcher(exOptions.getDirectoryObject().listFiles(), new ConcurrentHashMap<>(), options));
    }

    /**
     * The method that actually does the searching. Recursively goes through a
     * directory and through each subdirectory, adding each file to a HashMap
     * that contains two fields 1: The file extension(.exe,.js,.java) 2: A List
     * that contains the {@link BaseFileType}'s of all of the included files in
     * that directory.
     *
     * @param file_array An array containing the directory to be searched.
     * @param fileMap The Concurrent Hash Map that is passed through that gets
     * the file data added to it.
     * @param options The ExplorerOptions object for the current search.
     * @return The Concurrent Hash Map that contains the file information.
     */
    private ConcurrentHashMap searcher(File[] file_array, ConcurrentHashMap fileMap, ExplorerOptions options) {

        for (final File f : file_array) {
            if (f.isDirectory() && options.useRecursiveSearch()) {

                searcher(f.listFiles(), fileMap, options);

            } else if (f.isFile()) {
                String extension = FilenameUtils.getExtension(f.getName());

                if (options.getSearchableFileExtensions() == null) {
                    namer(f, fileMap);
                } else if (options.getSearchableFileExtensions().contains(extension)) {
                    namer(f, fileMap);
                }
            }

        }

        return fileMap;
    }

    public void namer(final File f, ConcurrentHashMap mapper) {

        String extension = FilenameUtils.getExtension(f.getName());
        BaseFileType bft = new BaseFileType(f);
        if (extension.equals("")) {
            extension = "N/A";
        }
        List<BaseFileType> nameList = (List<BaseFileType>) mapper.get(extension);
        // if list does not exist create it
        if (nameList == null) {
            nameList = new ArrayList<>();
            nameList.add(bft);
            mapper.put(extension, nameList);
            //System.out.println("Added new one to map.");
        } else {
            // add if item is not already in list
            if (!nameList.contains(bft)) {
                nameList.add(bft);
            }
            //System.out.println("Added to map.");
        }
    }

}
