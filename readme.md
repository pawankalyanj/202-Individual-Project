**CMPE-202 Individual Project**
---
**There are Two problems that I encountered while solving this Problem**

**First Problem I encountered is:**
---
First We have to determine wether that length of the Credit card number cannot exceed 19 digits and then we have to check for invalid characters in the number and after that we have to determine the type of card wether is it "Visa", "MasterCard", "AmericanExpress" or "Discover".

For this problem the most efficient solution would be using "Chain of Responsibility Pattern"

**Why did I used Chain of Resposibility pattern":**
Chain of Responsibility is a behavioral design pattern that lets us pass the request along the chain of handlers. When the request recvievd each handler decides wether to process the request to next step or not. In our problem we have to pass through few checks such as The Credit Card number lenght should be less than 19 digits if it's passed then the handler will move to next check that is inavlid characters in the string if it's passed then it will move to type of card issuer.

**Here's the UML Diagaram for Chain Of the Responisibility design Pattern.**

![UML Class Diagram Chain Of Responisility](https://user-images.githubusercontent.com/98665897/205528809-7c7e7114-e5b0-43e2-971b-d03cca8d04a1.png)

---

**Second Problem I found:**
---
The second problem is we need to create an multiple input and output objects for parsing the different types of file formats such as ".*csv",".*json" and ".*xml".
So for this problem we can use Factory design pattern becuse in facotry design pattern we can created a Abstract class and all the other child classses can inherit from the abstract class without exposing the creational logic, and also it is open for extension like in future we can also extend to accept the other file formats without changing the entire code.

**Here's the UML Diagram for Factory Method design Pattern**

![FileParser Factory Pattern Diagram](https://user-images.githubusercontent.com/98665897/205529588-6a8767e3-31d7-445a-94af-d7161f3ffd21.png)

---
Here's the UML diagram of entire Project:

![Class Diagram Overview](https://user-images.githubusercontent.com/98665897/205529695-07c222fe-983f-49c2-95d8-e94b136fc06b.png)

---

**How to run the project and Junit tests?**
---
Step1: Clone the git repo to your local Machine.

Step2: Check all the JAR files are in place.

Step3: Naviagte to test sources folder and select run all tests it will run all the unit tests.

Step4: To read the input files and get the output files place the input files in the appropriate directory and run the main.java then you can see the output files in the same directory as the input files.





