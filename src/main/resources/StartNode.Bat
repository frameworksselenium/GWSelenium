cd\
cd C:\Selenium\Libs

java -Dwebdriver.chrome.driver="C:\Selenium\Drivers\chromedriver.exe" -jar selenium-server-standalone-3.11.0.jar -role node  -hub http://localhost:4444/grid/register -port 4455 -browser browserName=chrome,maxInstances=2 -maxSession 2 -timeout 20000
pause
