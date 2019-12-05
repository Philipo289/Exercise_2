# Exercise 2 - Mobile Computing WS 2019
| Name          | Matrikelnummer | Kurs   |
| ------------- | -------------- | ------ |
| Dominik Heiny | 300149         | MSI SE |
| Philip Ebner  | 300453         | MSI SE |

## App: REST API + Offline-Handling

Die App benutzt eine dummy REST API, die unter folghendem Link zu finden ist: http://dummy.restapiexample.com/

Die App wurde nach dem MVVM Pattern gebaut.

**Wichtig**: Das offline Handling greift nur, wenn die App im Flugmodus gestartet wird. 

### APP-Konzept

In der App werden die Employee Daten der Dummy API angezeigt. Sollte die App gestartet werden, wenn keine Internetverbindung besteht, dann werden die Daten abgefragt, sobald wieder eine Verbindung besteht.


### APP-Architektur

Architektur-Model