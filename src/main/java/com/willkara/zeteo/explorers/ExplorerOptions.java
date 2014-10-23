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

import java.io.File;
import java.util.List;

/**
 * Sets the options to be used in the Explorer class. Recursive Search - Should
 * it go through every directory recursively? fileExtension - Should it search
 * for any file types explicitly? Put in JUST the file type (mp3/java) not
 * (.mp3/.java) or null to search for every file-type.
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public class ExplorerOptions {

    private File directoryPath;

    /**
     * Should it search through the directories recursively?
     */
    private boolean recursiveSearch = true;

    /**
     * Which file extension should it look for? Leave it blank for every.
     */
    private List<String> searchableFileExtension = null;

    /**
     * For now, the only argument it needs is the path to search.
     * @param path The path to search
     */
    public ExplorerOptions(String path) {
        directoryPath = new File(path);
    }

    /**
     * @return the directoryPath
     */
    public File getDirectoryObject() {
        return directoryPath;
    }

    /**
     * @param directoryObject the directoryPath to set
     */
    public void setDirectoryObject(File directoryObject) {
        this.directoryPath = directoryObject;
    }

    public enum FileTypes {
        audio,
        image,
        general;
    }

    /**
     * @return the recursiveSearch
     */
    public boolean useRecursiveSearch() {
        return recursiveSearch;
    }

    /**
     * @param recursiveSearch the recursiveSearch to set
     */
    public void setRecursiveSearch(boolean recursiveSearch) {
        this.recursiveSearch = recursiveSearch;
    }

    /**
     * @return the fileExtension
     */
    public List<String> getSearchableFileExtension() {
        return searchableFileExtension;
    }

    /**
     * @param extensions An array containing the file extensions you wish to
     * search for.
     */
    public void setSearchableFileExtension(List<String> extensions) {
        this.searchableFileExtension = extensions;
    }

}