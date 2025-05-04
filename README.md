# 📚 Library System – OOP Practice

A simple Java console application simulating a basic library system, built to practice object-oriented programming concepts from:

**"The Object-Oriented Thought Process" – Matt Weisfeld**

---

## 🎯 Concepts Practiced

- **Encapsulation**
- **Abstraction & Inheritance**
- **Polymorphism**
- **Composition over Inheritance**
- **Interfaces**
- **Dependency Injection**
- **SOLID Principles**

---

## ✅ SOLID Principles Applied

| Principle | Applied | Explanation |
|----------|---------|-------------|
| **S** – Single Responsibility | ✅ | Each class has one job: loaning, user handling, notification, etc. |
| **O** – Open/Closed | ✅ | New book types (e.g., `Article`, `Novel`) can be added without changing existing logic. |
| **L** – Liskov Substitution | ✅ | `Book` references accept any subclass without breaking behavior. |
| **I** – Interface Segregation | ⚠️ | Not critical yet; single interface is enough for now. |
| **D** – Dependency Inversion | ✅ | `LoanManager` depends on `NotificationService` interface, not a concrete class.

---

## 📁 Project Structure

- `Book`, `User`, `LoanRecord` – domain entities  
- `LoanManager`, `BookManager`, `UserManager` – business logic  
- `NotificationService`, `EmailNotificationService` – interface & implementation  
- `Library` – orchestrator class  
- `LoanManagerTest` – unit tests using JUnit 5 & Mockito

---

## 🛠 Technologies

- Java 21 
- Maven  
- JUnit 5  
- Mockito

---

## 🧪 How to Run & Test

```bash
mvn clean test