#!/bin/bash

# Recursive file convertion  utf-8 --> windows-1251
# Place this file in the root of your site, add execute permission and run
# Converts *.txt, *.html, *.css, *.js files.
# To add file type by extension, e.g. *.cgi, add '-o -name "*.cgi"' to the find command

read -p "Are you sure you want to continue? <y/N> " prompt
if [[ $prompt =~ [yY](es)* ]]
then
  (
	find ./ -name "*.txt" -o -name "*.html" -o -name "*.css" -o -name "*.js"  -type f |
	while read file
	  do
		QUOTE=\"
		echo $QUOTE$file$QUOTE
		mv $file $file.icv
		iconv -t WINDOWS-1251//TRANSLIT -f UTF-8 $file.icv > $file
		rm -f $file.icv
  done
  )
else (
  echo Canceled!
)
fi