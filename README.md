zeteo
=====

[![Build Status](https://travis-ci.org/willkara/zeteo.svg?branch=master)](https://travis-ci.org/willkara/zeteo)


A java library for file and directory statistics.

Ever wondered how many .js/.css/.java/.xml ...etc files a directory has? Jeteo is a java library that will list that information along with other statistics about a specified directory.

Over time, it will evolve to allow bulk file operations on certain file types.


##Note

This project is still in its infancy. The basic functions work but as a whole, it still needs a lot of work.


##Use Cases

* List all of the different types of files in a directory.
* List all images with specified dimensions.
* List all music files for a specified artist.
* Bulk change a directory full of music files for certain tags.

##Upcoming Features
* Sort the report output by field
* Audio Tagging implemenation
    * Sort directory by tag
	* Change tags for whole directory
* Export into different file formats
* Filetype checking by MIME type or file headers
* Better multithread support for large directories
* Examples
