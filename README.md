# CSCM94-Group2
# Project Notes
CSCM94- Software Engineering Principles
Group 2
Cafe 94 Assigment 2

# Project Title
Cafe 94

**Aim of the project** -to design all-in-one management tool for a local restaurant Cafe.
**Learning Outcomes** - To gain experience of implementing larger software as a part of a team

#Project Description
-The project focuses on producing application with attactive user interface for restaurant.
-The management system supports both customer and staff
-The project supports the requirments for the table bookings ( e.g. 4 tables of 2 seats, 4 tables of 4 seats and etc.)
- The project supports the requirement for customer booking
    1. number of guests to be seated
       2.date of booking
    3. time of the booking
    4. CustomerID- in our case is username as username is unique
       -Booking by default its 1 hour ( customers can request longer)
       -Customers can make food , drink and coffe order from menu
       -3 Types of orders can be taken ( eat-in , takeaway and delivery)
- The system has screen for Outstanding orders called Unfulfielled Order
- The system has 4 main types of staff at the restaurant : manager, chef,waiters,delivery drivers
- The system supports staff profiles
  -The system supports customer profiles
  -The system generates reports
  -The project is programmed in Java using JavaFX

#Install

#How to run
**To launch** - click on cafe94GUI.jar
**To run from IDE** - ( we worked on InteliJ) src/main/java/com/group2/cafe94gui/main.java

#Usage

#How to use it
**Staff* -waiter
1.When prompted to Login screen for username: waiter ; password: test -> click login
2. Once waiter is logged in the next screen gives two options for create order or outstanding orders .
3. When clicked on create order waiter is prompted to menu sceen where can choose food,drinks or coffee items. Waiter can add or remove items from menu clicking the buttons.
   4.Once items are selected total price is accumulated.
   5.Waiter can select order optios ( eat-in, delivery,and takeaway).
   5.1. If eat-in delivery , waiter is promted to table selection , order notes and total price , waiter can then place order.
   5.2.If takeaway is selected the waiter is promted to select pick up time , order notes and total price , waiter can then place order.
   5.3.if delivery order is selected waiter is promted to select enter address , order notes and total price, waiter can then place order.
6. If waiter clicks on outstandig order , the waiter is prompted to the screen for unfulfilled orders : sceen for order type , customer , ordertime , item name and table number.
   **Staff** - chef
   1.When prompted to Login screen for username: chef ; password: test -> click login
2. Once chef is logged in , the screen gives two options Home( where chef is able to add new item names and prices) and to check outstanding orders.
   **Staff** - manager
   1.When prompted to Login screen for username: manager ; password: test -> click login
   2.Once manager is logged in the screen gives two options: home and staff.
   2.1. When clicked on home the manager is able to see unfulifilled orders ( sceen with sceen for order type , customer , ordertime , item name and table number).
   2.2. When clicked on staff option the manager can see the staff's name types , total hrs worked.
   2.3.The manager can add staff . When clicked on that option , the manager can add the staff's names and type.The manager can cancel adding staff.
   2.4. The manager can add hrs to staff.
   **Customer**
   1.When prompted to Login screen for username: customer ; password: test -> click login
   2.When logged in the customer can see the platform options: view profile, make bookings, view menu:
   2.1. When clicked on create order customer is prompted to menu sceen where can choose food,drinks or coffee items. Customer can add or remove items from menu clicking the buttons.
   2.2.Once items are selected total price is accumulated.
   3.Customer can select order optios ( eat-in, delivery,and takeaway).
   3.1.If eat-in delivery , customer is promted to table selection , order notes and total price , waiter can then place order.
   3.2.If takeaway is selected the customer is promted to select pick up time , order notes and total price , customer can then place order.
   3.3.if delivery order is selected customer is promted to select enter address , order notes and total price, customer can then place order.
4. WHen customer selects Make bookings, customer than is promted to the booking screen where can choose a date,arrival time , and guest number. Customer can then see the date, the time, the guest number and if the booking was approved.Customer can also cancel booking.
   **Exit**
1. At the login page press cancel to exit

#Credits:
https://stackoverflow.com/questions/tagged/javafx
https://www.youtube.com/playlist?list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev

#Contributors
Group 2 , Swansea University , Computer Science Masters Students

#Upgrade
If we had more time we would add more pictures and make the menu more interactive 








