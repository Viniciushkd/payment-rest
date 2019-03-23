# payment-rest
Spring Rest
```
Para rodar no prompt de comando mvn sprint-boot:run
```
#### /payment
## POST
###### /save
```
{
	"idtransacao":1,
	"numerocartao":"123456789",
	"validade":"03/26",
	"valor":123.45,
	"bandeira":"master"
}
```
------
## GET
###### /findById/{id}
------
## PUT
###### /{id}
------
## DELETE
###### /{id}
------
