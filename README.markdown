[![Build Status](http://teamtter.com:8081/job/gwt-menu-framework/badge/icon)](http://teamtter.com:8081/job/gwt-menu-framework/)

# What is GWT-Menu-Framework ? 
GWT-Menu-Framework is a GWT based framework intending to enable fast application creation with a standard layout (header/footer) + a XML defined menu.
It's aim is to keep it simple and enforce the use of the MVP pattern in the client applications.
All screens in the clients applications should be MVP-based (a framework-handled Presenter and a View).

# Content
3 maven based projects
* a parent pom project ( gwt-menu-framework-project)
* a jar project: the framework ( gwt-menu-framework )
* a war project: a sample webapp using the framework (gwt-menu-framework-sample)

# Status
The core project is there and should not change alot. But it's far from being of any use to anyone at the moment !

# TODO
A *LOT* of stuffs !
* ensure it may be built/executed on the command line (only eclipse+gwt dev plugin right now)
* remove all trace of GXT 3 lib. Only use standard GWT components and layout
* make the app look like something. Anything but something (right now even the menus are mostly hidden)
* rework/clean/test the maven build (keep only what's necessary)
* ... 
