# payment-system API

# INTRODUCTION

This is an API that is used to make payment requests to flutter wave API.<br>
You can intergrate it in project to carry out online payements in your project.

# HOW TO INSTALL

-Clone the project to preffered directory.<br>
-Open your VScode and setup Java to work with VScode if you haven't. For more details on how to setup java in .<br>
VScode chechout https://code.visualstudio.com/docs/java/java-tutorial.<br>
-Install MySQL server if you haven't installed.<br>
-Install Postman if you don't have it on your machine.<br>

# CONFIGURING THE API

For the API to start running some configurations have to first be done, find application.properties file which is in payment-system/src/main/resources directory.<br>
After getting the application.properties file, you fill in the required settings respectively for example your server settings.<br>
For the sandbox.username and api.key are got from your flutter wave account https://flutterwave.com/.

# RUNNING THE API

-After setting your configurations for your server in the project, from your commandline in the root folder of the project run this command ./mvnw spring-boot:run.<br>
-At this point if every thing is done rigth, it should be able to run.<br>

# CHECKING THE API END POINTS

- To check the end points of the apllication, open postman<br>
Bellow are the end points of the API:
1. /db/transactions/save.<br>
2./verify<br>
3./makepayment<br>
4./makepayout<br>
5./flutterwave/historytransactions<br>
6./db/transactions.<br>

# makepayement end point (post)
makepayment end-point is for initiating a payment process.<br>
bellow is the example of making the request to makepayment end point<br>
request POST: http://localhost:4050/makepayment<br>
request Body:<br>
```json
{
    "amount": 3000,
    "currency": "UGX",
    "phoneNumber": "0000000000",
    "email": "testertester@gmail.com",
    "tx_ref": "lkfhjfdklhjdl9uy",
    "fullName": "Mugisha Derrick",
    "network": "Airtel",
    "redirect_url":"https://84f5-41-190-134-11.ngrok.io/verify",
    "description": "this is for testing"
 }
 ```
 <br>
NOTE: tx_ref value has to be different in every request you make, redirect_url is for recieving the status for payments<br>
the redirect_url calls the verify end-point eg in the above examlple the redirect_url is localhost:4050 exposed to the enternet using ngrok hence you see https://84f5-41-190-134-11.ngrok.io and then we add the end point verify hence ending up with something like this https://84f5-41-190-134-11.ngrok.io/verify.<br>

When the request is made a response is returned and below is the example of the request made:<br>
```json
{
    "status": "success",
    "message": "Charge initiated",
    "meta": {
        "authorization": {
            "redirect": "https://ravemodal-dev.herokuapp.com/captcha/verify/15973:713269e23dad031ace9f7e838e4e47ce",
            "mode": "redirect"
        }
    }
}
```
<br>
The response that is returned comes with the redirect url that you can  run in the computer browser in order to complete the payment.

# makepayout end point (POST)

This is the end point that you call to initiate payouts<br>
below is the example<br>
request POST: http://localhost:4050/makepayout,
request Body:<br>
```json
{
  "account_bank": "MPS",
  "account_number": "1111111111111",
  "amount": 5000,
  "narration": "UGX momo transfer",
  "currency": "UGX",
  "reference": "iijjghbnmn-kjhkj",
  "beneficiary_name": "Kwame Adew"
}
```
<br>
Below is the response that is returned:
<br>

```json
{
    "status": "success",
    "message": "Transfer Queued Successfully",
    "data": {
        "id": 207607,
        "account_number": "111111111111",
        "bank_code": "MPS",
        "full_name": "Kwame Adew",
        "created_at": "2021-09-27T13:28:33.000Z",
        "currency": "UGX",
        "amount": 5000,
        "fee": 500,
        "status": "NEW",
        "reference": "kjshdskjddjj",
        "narration": "UGX momo transfer",
        "complete_message": "",
        "requires_approval": 0,
        "is_approved": 1,
        "bank_name": "Mobile Money"
    }
}
```

<br>
NOTE: refference changes for every request that is made.<br>

# flutterwave/historytransactions end point (GET)
This is the end point that gets all sucssessful transactions from the flutterwave database.<br>
the request example:GET http://localhost:4050/flutterwave/historytransactions.<br>

# db/transactions/save end point(POST)

This is the end point you call when you saving data to MYSQL server.<br>
the request example:<br>
request POST http://localhost:4050/db/transactions/save.<br>
request Body :<br>
```json
{
    "amount": 3000,
    "currency": "UGX",
    "txRef": "uyoieruye87343483jo",
    "network": "Airtel",
    "paymentOption": "mobile money",
    "description": "this is for testing",
    "customerId": {
        "fullName": "Mugisha Derrick",
        "email": "tester@td.com",
        "phoneNumber": "0704838784"
    }
}
```
<br>

# transactions end point (GET)

this is the end point that returns all transaction history from MySQL database.<br>
Example:<br> GET http://localhost:4050/db/transactions



