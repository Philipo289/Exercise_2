# Exercise 2 - Mobile Computing WS 2019
| Name          |  Kurs  |
| ------------- | ------ |
| Dominik Heiny | MSI SE |
| Philip Ebner  | MSI SE |

## App: REST API + Offline-Handling

Die App benutzt eine dummy REST API, die unter folghendem Link zu finden ist: http://dummy.restapiexample.com/

Die App wurde nach dem MVVM Pattern gebaut.


### APP-Konzept

In der App werden die Employee Daten der Dummy API angezeigt. Sollte die App gestartet werden, wenn keine Internetverbindung besteht, dann werden die Daten abgefragt, sobald wieder eine Verbindung besteht.


### APP-Architektur
| Model          | View                 | Viewmodel            |
| -------------  | --------------       | ------               |
|                | FragmentEmployeeList | EployeeListViewModel |  
|                | EmplyeeItem          |                      |
|                | FragmentDetail       | DetailViewModel      |

-----> 

|Dummy REST API |
| ------------- |
|               |
