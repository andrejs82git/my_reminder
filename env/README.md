For use git_ignore_script you can do that 
```
curl https://raw.githubusercontent.com/andrejs82git/my_reminder/master/env/gitignoreScript.txt | sh
```
=========================
To get nodejs on raspbian use that script:
```
curl -sL https://deb.nodesource.com/setup_7.x | sudo -E bash -
```
=========================
To docker config in windows shell. Run it in cmd under admin permission.
```
docker-machine env --shell cmd | sed 's/set/setx/g' | sed  's/=/ /g'
```
