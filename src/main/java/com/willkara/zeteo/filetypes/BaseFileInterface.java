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
package com.willkara.zeteo.filetypes;

import java.io.File;
import java.util.Date;

/**
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public interface BaseFileInterface {

    /**
     * Deletes the specified file
     *
     * @param f The file to delete.
     * @return True OR False if the file was successfully delete.
     */
    boolean deleteFile(File f);

    /**
     * @return the createdDate
     */
    Date getCreatedDate();

    /**
     * Returns the extension of the specified file.
     *
     * @param f A Java {@link File} object containing the file.
     * @return A String that is the files extension
     */
    String getFileExtensionByFile(File f);
    // </editor-fold>

    /**
     * Returns the extension of the specified file.
     *
     * @param name A String containing the file name
     * @return A String that is the files extension
     */
    String getFileExtensionByFileString(String name);

    /**
     * Getters and setters for the variables.
     */
    // <editor-fold defaultstate="collapsed" desc=" Getters ">
    /**
     * @return the file_name
     */
    String getFileName();

    /**
     * @return the f
     */
    File getFileObject();

    /**
     * @return the file_path
     */
    String getFilePath();

    /**
     * @return the file_size
     */
    long getFileSize();

    /**
     * Returns the size of a file into a human readable string.
     *
     * @param size The size of the file (long)
     * @return A String containing a human readable value of the size.
     */
    String getFormattedFileSize(long size);

    /**
     * @return the lastAccessDate
     */
    Date getLastAccessDate();

    /**
     * @return the lastModifiedDate
     */
    Date getLastModifiedDate();

    /**
     * Renames the specified file.
     *
     * @param f The file to be renamed.
     * @param newName The new name of the file.
     * @return True OR False if the file was successfully renamed.
     */
    boolean renameFile(File f, File newName);
    
}
