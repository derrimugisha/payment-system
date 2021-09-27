# payment-system API

# HOW TO INSTALL

-Clone the project to preffered directory.<br>
-Open your VScode and setup Java to work with VScode if you haven't. For more details on how to setup java in .<br>
VScode chechout https://code.visualstudio.com/docs/java/java-tutorial.<br>
-Install MySQL server if you haven't installed.<br>
-Install Postman if you don't have it on your machine.<br>

# RUNNING THE API

After installing and having all the requirements below is how to run the application:<br>
-Open the API application in your VScode.<br>
-Run your MySQL server.<br>
-from the root folder of the project go to the src/resources/application.properties and add the configurations of your MySQl server<br>
below are the default configurations of MySQL server:<br>
spring.datasource.url = jdbc:mysql://<<localhost:3306>>/paymenthub?useSSL=false&serverTimezone=UTC<br>
spring.datasource.username=<<root>><br>
spring.datasource.password =<<  >> <br>
NOTE: configurations that are marked like <<example>> are the ones that need to be changed.<br>

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
{<br>
    "amount": 3000,<br>
    "currency": "UGX",<br>
    "phoneNumber": "0704838784",<br>
    "email": "testertester@gmail.com",<br>
    "tx_ref": "lkfhjfdklhjdl9uy",<br>
    "fullName": "Mugisha Derrick",<br>
    "network": "Airtel",<br>
    "redirect_url":"https://84f5-41-190-134-11.ngrok.io/verify",<br>
    "description": "this is for testing"<br>
 }   <br>
NOTE: tx_ref value has to be different in every request you make, redirect_url is for recieving the status for payments<br>
the redirect_url calls the verify end-point eg in the above examlple the redirect_url is localhost:4050 exposed to the enternet using ngrok hence you see https://84f5-41-190-134-11.ngrok.io and then we add the end point verify hence ending up with something like this https://84f5-41-190-134-11.ngrok.io/verify.<br>

When the request is made a response is returned and below is the example of the request made:<br>
{<br>
    "status": "success",<br>
    "message": "Charge initiated",<br>
    "meta": {<br>
        "authorization": {<br>
            "redirect": "https://ravemodal-dev.herokuapp.com/captcha/verify/15973:713269e23dad031ace9f7e838e4e47ce",<br>
            "mode": "redirect"<br>
        }<br>
    }<br>
}<br>
The response that is returned comes with the redierct url that you can be be run in the computer browsesr in order to complete the payment.
# makepayout end point (POST)
This is the end point that you call to initiate payouts<br>
below is the example<br>
request POST: http://localhost:4050/makepayout,
request Body:<br>
{<br>
  "account_bank": "MPS",<br>
  "account_number": "233542773934",<br>
  "amount": 5000,<br>
  "narration": "UGX momo transfer",<br>
  "currency": "UGX",<br>
  "reference": "iijjghbnmn-kjhkj",<br>
  "beneficiary_name": "Kwame Adew"<br>
}<br>
Below is the response that is returned:<br>
{<br>
    "status": "success",<br>
    "message": "Transfer Queued Successfully",<br>
    "data": {<br>
        "id": 207607,<br>
        "account_number": "233542773934",<br>
        "bank_code": "MPS",<br>
        "full_name": "Kwame Adew",<br>
        "created_at": "2021-09-27T13:28:33.000Z",<br>
        "currency": "UGX",<br>
        "amount": 5000,<br>
        "fee": 500,<br>
        "status": "NEW",<br>
        "reference": "kjshdskjddjj",<br>
        "narration": "UGX momo transfer",<br>
        "complete_message": "",<br>
        "requires_approval": 0,<br>
        "is_approved": 1,<br>
        "bank_name": "Mobile Money"<br>
    }<br>
}<br>
NOTE: refference changes for every request that is made.<br>

# flutterwave/historytransactions end point (GET)
This is the end point that gets all sucssessful transactions from the flutterwave database.<br>
the request example:GET http://localhost:4050/flutterwave/historytransactions.<br>

# db/transactions/save end point(POST)

This is the end point you call when you saving data to MYSQL server.<br>
the request example:<br>
request POST http://localhost:4050/db/transactions/save.<br>
request Body :<br>
{<br>
    "amount": 3000,<br>
    "currency": "UGX",<br>
    "txRef": "uyoieruye87343483jo",<br>
    "network": "Airtel",<br>
    "paymentOption": "mobile money",<br>
    "description": "this is for testing",<br>
    "customerId": {<br>
        "fullName": "Mugisha Derrick",<br>
        "email": "tester@td.com",<br>
        "phoneNumber": "0704838784"<br>
    }<br>
}<br>

# transactions end point (GET)

this is the end point that returns all transaction history from MySQL database.<br>
Example:<br> GET http://localhost:4050/db/transactions



