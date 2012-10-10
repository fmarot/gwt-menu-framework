package com.teamtter.tests;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

/**
 * The client side stub for the RequestFactory service.
 */
@ServiceName(value="com.teamtter.tests.GreetingService", locator="com.teamtter.tests.GuiceServiceLocator")
public interface GreetingContext extends RequestContext {
	Request<GreetingResponseProxy> greetServer(String name);
}
