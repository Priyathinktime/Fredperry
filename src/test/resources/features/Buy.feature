  @Alltest
Feature: Buy the product using productName
 
   Background: Navigate to Login page for Admin
     
   @Regression
   Scenario Outline: Experience on buy the product
    Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "fredperry" and password "staging"
   
      When click on Shopping in the UK section.
      And Navigate to Women Polo Shirts.
      And Add the desired T-shirt "<Product>" with size "12" to the shopping bag.
                                  
      And Proceed to secure checkout.
      And Select delivery options collect from store
      And Give the personal details.
          | Daniel|
          | Liyod |
          | daniel.illoyds@gmail.com |
          | 07772941511|
      And Choose a store for pickup.
      And Select the specified store "Fred Perry Camden, London".                                 
      And Click Next.
      And Opt for Check & Money Order as the payment method.
      And Click Update Address.
          | Daniel|
          | Liyod |
          | 2 Chilston Road | 
          |Tunbridge Wells  |
          | TN49LN  |
          | 07772941511|
     
      Then place the order.
      
      Examples:
      | Product   |
      | Cropped Gingham Piqué Shirt Fred Perry Green |
      | G12 Black Champagne Champagne   |
      | Open-Collar Piqué Shirt Black |
      
       @wrongProduct  @wrong
      Scenario: ordering the wrong product 
       Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "fredperry" and password "staging" 
      When click on Shopping in the UK section.
      And Navigate to Women Polo Shirts.
      And Add the desired T-shirt "Amy Perry Shirt Black" with size "6" to the shopping bag.
     
     @wrongcredentils  @wrong
     Scenario: navigate to the url with wrong username and password
     Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "hari" and password "staging"
     When click on Shopping in the UK section.
     
     
     @smoke
      Scenario: ordering the many  product 
       Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "fredperry" and password "staging" 
      When click on Shopping in the UK section.
      And Navigate to Women Polo Shirts.
      And get the desired T-shirt from excel
      And Add the desired T-shirt to the shopping bag.
      And Proceed to secure checkout.
      And Select delivery options collect from store
      
      
              @Dataproviderusingexcel
   Scenario Outline: Experience on buy the product
    Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "fredperry" and password "staging"
   
      When click on Shopping in the UK section.
      And Navigate to Women Polo Shirts.
      And get the desired T-shirt from excel with "<Products>" to the shopping bag.
      And Proceed to secure checkout.
     
      
       Examples:
          | Products | 
          | Product1 |
          | Product2 |
          | Product3 |
          | Product4 |
          
          
     @Sanity
   Scenario Outline: checking the sanity testing
    Given User navigate to Login Page for Admin "www-stagem3.fredperry.com" with username "fredperry" and password "staging"
   
      When click on Shopping in the UK section.
      And Navigate to Women Polo Shirts.
      And Add the desired T-shirt "Cropped Gingham Piqué Shirt Fred Perry Green" with size "12" to the shopping bag.
                                  
      And Proceed to secure checkout.
      And Select delivery options collect from store
      And Give the personal details.
          | Daniel|
          | Liyod |
          | daniel.illoyds@gmail.com |
          | 07772941511|
      And Choose a store for pickup.
      And Select the specified store "Fred Perry Camden, London".                                 
      And Click Next.
      And Opt for Check & Money Order as the payment method.
      And Click Update Address.
          | Daniel|
          | Liyod |
          | 2 Chilston Road | 
          |Tunbridge Wells  |
          | TN49LN  |
          | 07772941511|
     
      Then place the order.       
         
      
      