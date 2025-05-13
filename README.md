Why the Online Platform Was Chosen
While I acknowledge your request for locally run applications, I selected Let's Shop application because it provides a realistic e-commerce environment to:
      . Practice end-to-end testing (UI, API).
      . Refine automation skills (using tools like Selenium, TestNG, or Cypress).
      . Explore edge cases (e.g., invalid inputs, payment failures).
Website Overview:
  URL: https://rahulshettyacademy.com/client/
  Purpose: A training platform designed for practicing automation testing and QA workflows.
Key Features Tested:
  User Authentication:
    . Login/registration flows (email/password validation).
    . Password reset functionality.
  Product Catalog
    . Browsing products by categories (e.g., electronics, fashion).
    . Search and filter functionality.
    . Product details (images, descriptions, pricing).
  Shopping Cart & Checkout
    . Adding/removing items from the cart.
    . Order total calculation and validation.
  Order Management
    . Viewing order history.
    . Tracking order status.

Setup & run the test:
This project automates test scenarios for Let's Shop application using Selenium WebDriver with Java proramming language. Follow the steps below to set up and run the tests,
Prerequisites:
    Java JDK 17+
    Maven
    Chrome (latest version)
    Eclipse IDE
Clone the repository:
  git clone https://github.com/MohamedHafdi/GitDemo.git 
Run tests:
  open command line, 
  access to the project (cd path/to/GitDemo)
  run test case 2 from the test plan execute the command:
    . mvn test -PCart_Page
  run test case 7:
    . mvn test -PORDERS_Page
  run test case 17:
    . mvn test -PInvalid_Authentication
  run all the tests:
    . mvn test -PAll_Tests
you can open the report located on Reports folder (index.html) on your browser to check the results,

      
