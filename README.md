# payment-rest
Spring Rest
```
Para rodar no prompt de comando mvn sprint-boot:run
```
#### /payment
## POST
###### /save
```
curl -X POST \
  http://localhost:8080/payment/save \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 3550d48d-20ae-3a89-ca5e-3acb990553db' \
  -d '{
	"idtransacao":1,
	"numerocartao":"123456789",
	"validade":"03/26",
	"valor":123.45,
	"bandeira":"master"
}'
```
------
## GET
###### /findById/{id}
```
curl -X GET \
  http://localhost:8080/payment/findById/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 01a16dbd-0d2e-eaf8-724b-5ddcb3aa0c76'
```
------
## PUT
###### /{id}
```
curl -X PUT \
  http://localhost:8080/payment/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 7ef389bf-8211-1b76-8c68-156a67ed8412' \
  -d '{
	"idtransacao":1,
	"numerocartao":"23424234234",
	"validade":"03/26",
	"valor":123.45,
	"bandeira":"master"
}'
```
------
## DELETE
###### /{id}
```
curl -X DELETE \
  http://localhost:8080/payment/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: ddc691a3-fedc-8b40-f8d1-526e10f9857c'
```
------
