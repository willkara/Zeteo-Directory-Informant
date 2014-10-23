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
package com.willkara.zeteo;

import com.willkara.zeteo.explorers.Explorer;
import com.willkara.zeteo.explorers.ExplorerOptions;
import com.willkara.zeteo.explorers.ExplorerResult;

/**
 * The main interface to the tool through the command line.
 *
 * @author willkara  
 * William Karavites - wkaravites@gmail.com
 * http://willkara.com
 */
public class Zeteo {

    /**
     * Main method for the command line.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //stackoverflow.com/questions/7341683/parsing-arguments-to-a-java-command-line-program
        ExplorerOptions eo = new ExplorerOptions("/Users/willkara/Development/");
        Explorer wow = new Explorer();
        eo.setRecursiveSearch(true);
        ExplorerResult result = wow.search(eo);
        
        result.getReport().exportToTerminal();
        
        
        

    }

}