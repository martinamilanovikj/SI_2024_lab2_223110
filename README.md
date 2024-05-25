# Втора лабораториска вежба по Софтверско инженерство 
**Мартина Милановиќ, бр. на индекс 223110**

**Control flow graph:**

![Control flow graph](https://github.com/martinamilanovikj/SI_2024_lab2_223110/assets/165427002/8949d3e1-6878-4117-a02a-5e6ce189dcee)

**Цикломатска комплексност:**
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.


**Тест случаи според критериумот Every Branch**


   

AllItems {    Name      Barcode    Price    Discount} Payment   
          
          1.                  {null}                     X
         
          2.  {}         0456       302       0.2f     2000
         
          3.  notebook    null       X         X        X
         
          4.  pencil     -1356       X         X        X
         
          5.  pen         8573      302       0.2f      2

          
Tест 1 е случај кога AllItems е null односно имаме празна листа.

Teст 2 е случај во кој немаме име, имаме исполнет услов баркодот да започнува на 0, и исполнет услов Price * Discount да ни е помало од Payment, програмата враќа true.

Teст 3 е случај во кој имаме име, но Barcode ни е null со што имаме throw exception и со тоа завршува програмата.

Tест 4 е слично со тест 3, меѓутоа сега имаме Barcode да почнува со негативна вредност со што повторно имаме throw exception.

Teст 5 сите услови ни се исполнети освен условот сумата да е помала од Payment, со што програмата враќа false. 

**Тест случаи според критериумот Multiple Condition**


if(item.getPrice() > 300              if( item.getDiscount() > 0                if(item.getBarcode().charAt(0) == '0'
        
         Т                                   T                                  T
         
         T                                   T                                  F
       
         Т                                   F                                  F
       
         F                                   T                                  T
        

         Teст случаи:
         1.price = 350; discount = 0.3; barcode = 04628;
         
         2.price = 489; discount = 0.5; barcode = 74858;
         
         3.price = 350; discount = 0; barcode = 83678;
         
         4.price = 300; discount = 0.7; barcode = 02535;
         
         
