# Extended_Report

Hi i have completed this project Using maven we can directly configure this project in jenkins also after pushing to git.
I have pushed the code to my GITHUB REPO.

https://github.com/broxsss/whatfixproject

Here are prerequisite to run the test case;

~~~~ 
1.) Method to run 
  a.)  By TestNG goto SRC/test/java
       then goto to whatfix.SelfHelpautomation.TestCases Package
       open Test case -->LoginPageSelfHelpTag_TC001.java   from above package.
       right click and run as TestNG
       
  b.)  As it's maven project you can define goal for it and then run
       Goto RunConfiguration and there go to maven 
       give "clean test"  in Goal and run.(don't give inverted comma's)
~~~~       

plz check report and screenshot after refreshing the project.
       
 I have included extent report which will generate report after every run.(check report folder)   
 I have included screenshot on fail so if your test fails the screenshot will be generated. (check screenshot folder)   
 To check screenshot for failure is running fine or not you can run LoginPageSelfHelpTagfailure_TC002.java

