# FilterChainingApp

Filter Chaining App
1. Two filters are created(Log filter and Demo Filter) and mapped to servlet(Target Servlet)
2. Similar to ServletConfig we have FilterConfig here. Using this FilterConfig object we will get the ServeltContext object using which we can get the log() method.
3. Here in the LogFilter as the FilterConfig object scope is limited to init(FilterConfig fConfig) method. So, in order to use the FilterConfig in doFilter() method we need to increase the scope. So, we have created a private instance variable and in the init() method we are assigning the local filterConfig object with instance filterConfig object which was created by the container.
4. In the destroy() method, we are aging making the FilterConfig object as null because the usage is done.
