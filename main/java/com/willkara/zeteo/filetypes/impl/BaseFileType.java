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
package com.willkara.zeteo.filetypes.impl;

import com.willkara.zeteo.filetypes.BaseFileInterface;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * The base file type for all of the other file types. This class is the base
 * because it contains info that every file type will have. If you create a new
 * file type, it should extend this class.
 *
 * This class is mainly used for getting information ABOUT files. Not actually
 * acting on that file.
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public class BaseFileType implements BaseFileInterface {

    private String fileName;

    private long fileSize;

    private String filePath;

    private Date lastModifiedDate;
    private Date createdDate;
    private Date lastAccessDate;


    /**
     * Creates the BaseFileType object from the Java {@link java.io.File} class
     * as an argument.
     *
     * @param f The file object
     */
    public BaseFileType(File f) {

        if (f.isFile()) {
            BasicFileAttributes attr;
            try {
                attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

                fileName = f.getName();
                filePath = f.getCanonicalPath();
                fileSize = f.length();

                lastModifiedDate = new Date(attr.lastModifiedTime().toMillis());
                createdDate = new Date(attr.creationTime().toMillis());
                lastAccessDate = new Date(attr.lastAccessTime().toMillis());
            } catch (IOException ex) {
                Logger.getLogger(BaseFileType.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Getters and setters for the variables.
     */
    // <editor-fold defaultstate="collapsed" desc=" Getters ">
    /**
     * @return the file_name
     */
    @Override
    public String getFileName() {
        return fileName;
    }

    /**
     * @return the file_size
     */
    @Override
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @return the file_path
     */
    @Override
    public String getFilePath() {
        return filePath;
    }

    /**
     * @return the lastModifiedDate
     */
    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @return the createdDate
     */
    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the lastAccessDate
     */
    @Override
    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    /**
     * @return the f
     */
    @Override
    public File getFileObject() {
        return new File(this.filePath);
    }
    
    /**
     * Deletes the specified file
     *
     * @param f The file to delete.
     * @return True OR False if the file was successfully delete.
     */
    @Override
    public boolean deleteFile(File f) {
        return f.delete();
    }

    /**
     * Renames the specified file.
     *
     * @param f The file to be renamed.
     * @param newName The new name of the file.
     * @return True OR False if the file was successfully renamed.
     */
    @Override
    public boolean renameFile(File f, File newName) {
        return f.renameTo(newName);
    }

    /**
     * Returns the size of a file into a human readable string.
     *
     * @param size The size of the file (long)
     * @return A String containing a human readable value of the size.
     */
    @Override
    public String getFormattedFileSize(long size) {
        return FileUtils.byteCountToDisplaySize(size);
    }

    /**
     * Returns the extension of the specified file.
     *
     * @param name A String containing the file name
     * @return A String that is the files extension
     */
    @Override
    public String getFileExtensionByFileString(String name) {
        return FilenameUtils.getExtension(name);
    }

    /**
     * Returns the extension of the specified file.
     *
     * @param f A Java {@link File} object containing the file.
     * @return A String that is the files extension
     */
    @Override
    public String getFileExtensionByFile(File f) {
        return FilenameUtils.getExtension(f.getName());
    }

    // </editor-fold>
}
