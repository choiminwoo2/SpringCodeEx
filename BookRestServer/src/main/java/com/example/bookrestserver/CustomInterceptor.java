package com.example.bookrestserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CustomInterceptor implements ClientHttpRequestInterceptor {
    Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        printRequest(request, body);
        ClientHttpResponse response = execution.execute(request,body);
        printResponse(response);
        return response;
    }

    private void printRequest(final HttpRequest request, final byte[] body){
        logger.info("URI: {}, Method: {} Headers: {}, \n Body: {} ",
                request.getURI(), request.getMethod(), request.getHeaders(), new String(body, StandardCharsets.UTF_8));
    }
    private void printResponse(final ClientHttpResponse res) throws IOException{
        String body = new BufferedReader(new InputStreamReader(res.getBody(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        logger.info(" Status: {},\n Headers: {},\n Body: {}\n",
                res.getStatusCode(), res.getHeaders(), body);

    }
}
