package it.sistinf.crash.hellosoap.webservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import crash.sistinf.it.welcome_soap.GetWelcomeRequest;
import crash.sistinf.it.welcome_soap.GetWelcomeResponse;
import crash.sistinf.it.welcome_soap.Greeting;

@Endpoint
public class WebServiceEndpoint {

    private static final String NAMESPACE_URI = "http://it.sistinf.crash/welcome-soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWelcomeRequest")
	@ResponsePayload
	public GetWelcomeResponse getCountry(@RequestPayload GetWelcomeRequest request) {
        GetWelcomeResponse response = new GetWelcomeResponse();
        Greeting greeting = new Greeting();
        greeting.setName(request.getName());
        greeting.setWelcome(String.format("Hello %s!", greeting.getName()));
		response.setGreetings(greeting);

		return response;
	}

}