/*
 * Copyright (C) 2014 William Karavites
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
package com.willkara.zeteo.reporters.impl;

import com.willkara.zeteo.explorers.ExplorerResult;
import com.willkara.zeteo.filetypes.impl.BaseFileType;
import com.willkara.zeteo.reporters.BaseReportInterface;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 * Handles the output/export of reports for the File/Directory information.
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public class FileDirectoryReport implements BaseReportInterface {

    ExplorerResult ex;

    /**
     * He constructs stuff. He's a builder.
     *
     * @param er Hammer and Nails
     */
    public FileDirectoryReport(ExplorerResult er) {
        ex = er;

    }

    /**
     * Method that helps choose how to export the report.
     *
     * @param exportType Export to terminal, CSV, JSON or XML.
     */
    @Override
    public void export(String exportType) {
        switch (exportType) {
            case "terminal":
                exportToTerminal();
                break;

        }
    }

    /**
     * Print out to the terminal
     */
    @Override
    public void exportToTerminal() {
        System.out.println(name + "\n\n");
        System.out.println("File Type: Number of Files , Size of Files");
        System.out.println("-------------------------------------------");

        for (Map.Entry<String, List<BaseFileType>> e : ex.getFileCounter().entrySet()) {
            String ext = e.getKey();
            System.out.printf("%s: %d, %s\n", ext, ex.getCountOfFilesForExtension(ext), FileUtils.byteCountToDisplaySize(ex.getFileTypeTotalSize(ext)));
        }

        System.out.println("-------------------------------------------");
        System.out.println("Most common file type: " + ex.getMostCommonFileType());
        System.out.println("-------------------------------------------");
        System.out.println("Total count of files: " + ex.getTotalFileCount());
        System.out.println("Total size of files: " + FileUtils.byteCountToDisplaySize(ex.getTotalSizeCount()));

    }

    @Override
    public void exportAsCSV(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportAsJSON(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportAsXML(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
