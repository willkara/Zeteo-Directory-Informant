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
package com.willkara.zeteo.reporters;

/**
 * The base file for all of the reporters. They will all be using the same
 * functionality, just implementing it differently.
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public interface BaseReportInterface {

    final String name = "Zeteo Directory Informant";

    /**
     * Sends out the export command to the proper method. I have to find a
     * better way to implement the whole export procedure.
     *
     * @param exportType
     */
    void export(String exportType);

    /**
     * Skeleton method to sort the results. Will most likely sort by the
     * attributes available in the Explorer Result.
     */
    public void sort();

    /**
     * Export to the terminal
     */
    void exportToTerminal();

    /**
     * Export as a CSV file
     *
     * @param fileName
     */
    void exportAsCSV(String fileName);

    /**
     * Export as a JSON file
     *
     * @param fileName
     */
    void exportAsJSON(String fileName);

    /**
     * Export as an XMl file
     *
     * @param fileName
     */
    void exportAsXML(String fileName);

}
