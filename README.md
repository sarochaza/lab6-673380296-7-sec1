# 🍃 Spring Boot + Thymeleaf Custom ViewResolver

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?style=for-the-badge&logo=thymeleaf)](https://www.thymeleaf.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-red?style=for-the-badge&logo=apachemaven)](https://maven.apache.org/)

โปรเจกต์สาธิตการกำหนดการทำงานของ **Custom ViewResolver** ใน Spring Boot ร่วมกับ **Thymeleaf Template Engine** โดยไม่ต้องเชื่อมต่อฐานข้อมูล เพื่อศึกษาหลักการออกแบบซอฟต์แวร์ (Software Design Principles)

---

## 📌 ข้อมูลรายวิชา
* **วิชา:** CP353002 Principles of Software Design
* **หัวข้อ:** การกำหนด (Configure) ViewResolver ของ Spring Boot ที่ใช้ Thymeleaf เป็น View Engine
* **จัดทำโดย:** [ใส่ชื่อ-นามสกุลของคุณ] (รหัสนักศึกษา: [ใส่รหัสนักศึกษาของคุณ])

---

## 💡 แนวคิดการออกแบบ (Software Design Principles)

โปรเจกต์นี้ถูกออกแบบมาเพื่อสะท้อนหลักการออกแบบซอฟต์แวร์ที่ดี 2 ประการหลัก:

1. **Separation of Concerns (SoC):** 
   * **Controller** รับผิดชอบเฉพาะการรับ HTTP Request และจัดเตรียมข้อมูลใส่ `Model`
   * **ViewResolver** รับผิดชอบเฉพาะการแปลง "ชื่อ View เชิงตรรกะ" (Logical View Name) ไปเป็นตำแหน่งไฟล์ HTML จริงบน ดิสก์
   * การแยกหน้าที่นี้ทำให้สามารถย้ายตำแหน่งโฟลเดอร์เก็บ HTML โดยไม่ต้องแก้ไขโค้ดฝั่ง Controller เลย

2. **Dependency Inversion Principle (DIP):**
   * Controller ไม่ขึ้นกับตำแหน่งไฟล์จริงบน Disk (`src/main/resources/...`)
   * Controller ขึ้นกับเพียง Abstraction ซึ่งก็คือสตริงชื่อ View เช่น `"home"` หรือ `"about"` เท่านั้น

---

## 📁 โครงสร้างโปรเจกต์ (Project Structure)

```text
spring-thymeleaf-demo/
 ├── pom.xml                                  <- ไฟล์ตั้งค่า Dependency (Spring Web, Thymeleaf)
 ├── .gitignore
 ├── README.md
 └── src/main/
      ├── java/com/example/demo/
      │    ├── DemoApplication.java            <- จุดเริ่มต้นโปรแกรม (Main Application)
      │    ├── config/
      │    │    └── ThymeleafConfig.java      <- Custom ViewResolver Config (กำหนดตำแหน่งไฟล์ HTML)
      │    └── controller/
      │         └── HomeController.java        <- Controller รับ Request
      └── resources/
           ├── application.properties          <- ตั้งค่า Server Port และ Cache
           └── my-templates/                   <- โฟลเดอร์ Custom Templates (เปลี่ยนจาก default /templates/)
                ├── home.html
                └── about.html
