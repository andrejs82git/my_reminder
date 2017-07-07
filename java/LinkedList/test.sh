#!/bin/bash
#need lib https://github.com/rvoicilas/inotify-tools/wiki 

while true 
do inotifywait -r -e modify --exclude '.*\.(class|sh|swp)$' ./ 
	tput setaf 2
	echo ================
	tput sgr0
	javac -cp .:../lib/* *.java && 
	java -cp .:../lib/* org.junit.runner.JUnitCore SuiteTest
done
