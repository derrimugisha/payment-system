package com.paymentSystem.paymentsystem.controller;

import com.paymentSystem.paymentsystem.repo.UserRepo;
import com.paymentSystem.paymentsystem.repo.TransactionsRepo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.paymentSystem.paymentsystem.models.User;
import com.paymentSystem.paymentsystem.repo.PayOutData;
import com.paymentSystem.paymentsystem.models.Transactions;
import com.paymentSystem.paymentsystem.repo.VerifyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Collections;
import java.util.HashMap;
import com.paymentSystem.paymentsystem.repo.PaymentData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class ApiCntroller {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TransactionsRepo transactionsRepo;

    @Value("${api.key}")
    private String appKey;

    // this is for testing
    @GetMapping(value = "/")
    public String getPage() {
        return appKey;
    }

    // this is for testing
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/db/transactions")
    public List<Transactions> getTransactions() {
        return transactionsRepo.findAll();
    }

    // the below end point is to save to the database directly
    @PostMapping(value = "/db/transactions/save")
    public String saveTransactions(@RequestBody Transactions transactions) {
        transactionsRepo.save(transactions);
        return "saved in the database";
    }

    // this is for testing
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved";
    }

    @GetMapping("verify")
    public Object verify(@RequestParam Object resp) {
        return resp;
    }

    // this is for testing
    @GetMapping("verify2")
    public Object verify2(@RequestBody VerifyData resp) {
        VerifyData resp2 = resp;
        return resp2.getModel();
    }

    // this endpoint is for test
    @GetMapping("/api/foos")
    // @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

    @PostMapping(value = "/makepayment")
    public Object paymentBody(@RequestBody PaymentData paymentContainer) {

        RestTemplate restTemplate = new RestTemplate();
        String api = appKey;
        String url = "https://api.flutterwave.com/v3/charges?type=mobile_money_uganda";
        // create headers
        HttpHeaders headers = new HttpHeaders();

        // set content-type header
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set accept header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set authorization header
        headers.add("Authorization", "Bearer " + api);
        // long amount = paymentContainer.getAmount();

        String amount = Long.toString(paymentContainer.getAmount());
        String currence = paymentContainer.getCurrence();
        String email = paymentContainer.getEmail();
        String txRef = paymentContainer.getTxRef();
        String fullName = paymentContainer.getFullName();
        String phoneNumber = Long.toString(paymentContainer.getPhoneNumber());
        String network = paymentContainer.getNework();
        String redirect = paymentContainer.getRedirectUrl();
        // String paymentOption = paymentContainer.getPaymentOption();
        // String description = paymentContainer.getDescription();

        // Object for payment process
        HashMap<String, String> map = new HashMap<>();
        map.put("amount", amount);
        map.put("currency", currence);
        map.put("email", email);
        map.put("tx_ref", txRef);
        map.put("fullname", fullName);
        map.put("phone_number", phoneNumber);
        map.put("network", network);
        map.put("redirect_url", redirect);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Object> result = restTemplate.postForEntity(url, entity, Object.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            return result.getBody();
        } else {
            System.out.print("this is for the error");
            return result.getBody();
        }
    }

    @PostMapping(value = "/makepayout")
    public Object makePayOut(@RequestBody PayOutData payOutData) {
        RestTemplate restTemplate = new RestTemplate();
        String api = "FLWSECK_TEST-91d560bbdcddae17f003cb77bca3acaa-X";
        String url = "https://api.flutterwave.com/v3/transfers";
        // create headers
        HttpHeaders headers = new HttpHeaders();

        // set content-type header
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set accept header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set authorization header
        headers.add("Authorization", "Bearer " + api);

        // Object for payoutdata
        HashMap<String, String> map = new HashMap<>();
        map.put("account_bank", payOutData.getAccountBank());
        map.put("account_number", payOutData.getAccountNumber().toString());
        map.put("amount", payOutData.getAmount());
        map.put("narration", payOutData.getNarration());
        map.put("currency", payOutData.getCurrency());
        map.put("reference", payOutData.getReference());
        map.put("beneficiary_name", payOutData.getBeneficiaryName());

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Object> result = restTemplate.postForEntity(url, entity, Object.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            return result.getBody();
        } else {
            return result.getBody();
        }

    }

    @GetMapping(value = "/flutterwave/historytransactions")
    public Object flutterWaveTransctionHistory() {
        RestTemplate restTemplate = new RestTemplate();

        String apiKey = appKey;

        final String uri = "https://api.flutterwave.com/v3/transactions";

        // create headers
        HttpHeaders headers = new HttpHeaders();

        // set content-type header
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set accept header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set authorization header
        headers.add("Authorization", "Bearer " + apiKey);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

        String json = response.getBody();
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

        return convertedObject;

    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        userRepo.save(updatedUser);
        return "Updated..... ";

    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id:" + id;
    }

    @GetMapping(value = "/tester")
    public String getTester() {
        final String uri = "https://quoters.apps.pcfone.io/api/random";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

}
