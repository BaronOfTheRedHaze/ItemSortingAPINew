Dokumentation för REST api inlämningsuppgift

Denna aplikation används till att lagra information om olika objekt.

Det anropas via REST api och skriven i Java. 

Informationen som skickas sparas i en Arraylist.

Grundstrukturen är skappad i struktur av AWS codestar exempel. 

För att kunna återskapa detta lokalt behöver man: 
Springframework
Junit
Mokito

Projektet består av fyra delar: 
ItemController: Den skapar vägen för api-anropen och så att den retunerar rätt data. Dessutom har den lite grundledande fel kontroll.  
Item: Definerar objektet Item. Inkluderar även getters och setters. 
ItemStorage: Skapar objektet myItem och förvarar de som info. 
Application: Behövs för att starta projektet

Jag har även två testfiler (vilket är för ItemController och ItemStorage) som är där för att säkerställa att kommandon som anropas är korrekta. 

Med de nuvarande testerna så är testcoverage på 66%.

