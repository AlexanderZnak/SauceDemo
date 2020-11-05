1. mvn versions:display-dependency-updates:
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0
2. mvn versions:update-properties:
[INFO] Updated ${selenium.version} from 3.141.59 to 4.0.0-alpha-6
[INFO] Major version changes allowed
[INFO] Updated ${testng.version} from 7.1.0 to 7.3.0
3. mvn clean test:
Tests run: 33, Failures: 8, Errors: 0, Skipped: 0
4.
а) mvn clean test -Dtest=ItemTest,OverviewTest
b) mvn clean test -Dtest=CheckoutTest#cancel+emptyLastName
5. mvn clean -f C:/Users/Саша/IdeaProjects/SauceDemo/pom2.xml test -Dtest=OverviewTest
6. 
a) mvn clean test -Dtest=LoginTest#AuthorizationWithInvalidData -Dbla=bla -Dbla2=bla
b) mvn clean test -Dbrowser=chrome -Dtest=OverviewTest
c) mvn clean test -Dbrowser=opera -Dtest=OverviewTest
d)






