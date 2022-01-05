package com.ist412.efinance.service;

import com.ist412.efinance.model.Plaid;
import com.ist412.efinance.model.User;
import com.ist412.efinance.repository.PlaidRepository;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


//public class PlaidServiceImpl implements PlaidService {
//
////    private static PlaidApi plaidClient;
//
////    @Override
////    public void newPlaidClient() throws IOException{
//
////        HashMap<String, String> apiKeys = new HashMap<String, String>();
////        apiKeys.put("clientId", "client");
////        apiKeys.put("secret", "secret");
////        ApiClient apiClient = new ApiClient(apiKeys);
////        apiClient.setPlaidAdapter(ApiClient.Sandbox);
////
////        plaidClient = apiClient.createService(PlaidApi.class);
////
////        User userFromDB = new User();
////        String clientUserId = userFromDB.getUid().toString();
////        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
////                .clientUserId(clientUserId);
////
////        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
////                .user(user)
////                .clientName("Plaid Test App")
////                .products(Arrays.asList(Products.fromValue("auth")))
////                .countryCodes(Arrays.asList(CountryCode.US))
////                .language("en")
////                .redirectUri("https://domainname.com/oauth-page.html")
////                .webhook("https://webhook.example.com");
////
////
////        Response<LinkTokenCreateResponse> response = plaidClient
////                .linkTokenCreate(request)
////                .execute();
////
////
////        response.body();
//
//    }
//
//}
