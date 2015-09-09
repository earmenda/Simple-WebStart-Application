# Simple-WebStart-Application
This is a simple webstart application. 

Using this to replicate a bug introduced in Java8u40. 

There is a memory leak in using the JNLPClassLoader to get resource streams for non class resources. com.deploy.security.LazyRootStore has a reference to two HashMaps that store LinkedLists that are growing with no bound. 