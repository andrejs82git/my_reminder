tput setaf 2
echo download junit-4.12
tput sgr0
wget -O junit.jar http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar -q --show-progress

tput setaf 2
echo download hamcrest-core-1.3
tput sgr0
wget -O hamcrest-core-1.3.jar http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar -q --show-progress

