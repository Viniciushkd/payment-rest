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
  -H 'postman-token: 2bb1d255-2675-3d5c-9d89-7740d9cb6669' \
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
  -H 'content-type: application/json' \
  -H 'postman-token: 9da4a262-35e0-3431-1237-d608eff23251' \
  -d '{
	"idtransacao":1,
	"numerocartao":"123456789",
	"validade":"03/26",
	"valor":123.45,
	"bandeira":"master"
}'
```
------
## PUT
###### /{id}
```
curl -X PUT \
  http://localhost:8080/payment/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 587d434f-27bc-a739-fe77-bbae349700d3' \
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
  http://localhost:8080/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 834e98c9-4dbf-961c-5aea-cd50c0af9755' \
  -d '{
	"idtransacao":1,
	"numerocartao":"123456789",
	"validade":"03/26",
	"valor":123.45,
	"bandeira":"master"
}'
```
------
