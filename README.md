# Design Principles

1. **Single Responsibility Principle (SRP):**
    - Description: The Single Responsibility Principle states that a class or module should have only one reason to change. It should have a single responsibility or job to perform.
    - Example: The WordCounter class in the WordCounter application follows the SRP by having the responsibility of counting words and delegating the translation to the Translator class.

2. **Dependency Injection (DI):**
    - Description: Dependency Injection is a design principle that promotes loose coupling and facilitates the reuse of components. It involves injecting dependencies into a class rather than creating them internally.
    - Example: In the WordCounter class, the Translator dependency is injected through the constructor, allowing different Translator implementations to be used without modifying the WordCounter class.

3. **Encapsulation:**
    - Description: Encapsulation is the process of hiding the internal details of an object and providing a public interface for interacting with it. It helps maintain the integrity and consistency of an object's state.
    - Example: The WordCounter class encapsulates the wordCounts map by keeping it private and providing public methods like addWords() and getCount() to interact with it.

4. **Testability:**
    - Description: Testability refers to designing code in a way that makes it easy to write tests for. It involves separating concerns, using dependency injection, and writing testable code.
    - Example: The WordCounter class is designed to be testable by injecting the Translator dependency and using mock objects in the WordCounterTest class to verify its behavior.

5. **Modularization:**
    - Description: Modularization is the process of dividing a system into smaller, independent modules that can be developed, tested, and maintained separately. It promotes code organization and reusability.
    - Example: The WordCounter application is modularized into different packages, such as service and test, to separate concerns and improve code maintainability.

6. **Code Reusability:**
    - Description: Code reusability aims to write code that can be easily reused in different parts of an application or even in other projects. It reduces duplication, improves maintainability, and saves development time.
    - Example: The Translator class in the WordCounter application can be reused in other parts of the system or in different applications that require translation functionality.
      Feel free to modify or expand upon the descriptions and examples based on your specific needs and understanding of the design principles.








