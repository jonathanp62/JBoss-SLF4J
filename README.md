# JBoss-SLF4J
Use the SLF4J logging facade over the built-in JBoss logging mechanism

The extended logger can be used by 1) adding org.slf4j.ext in the dependencies section of the manifest
and 2) adding a similar dependency in the jboss-deployment-structure document.

I also added org.slf4j to the dependencies section of the manifest but don't think it was required.

The format string set up in the JBoss admin console looks like this:
	%d{HH:mm:ss,SSS} [%X{requestId}] [%t] %-5p [%c] [%C{1}::%M] %s%n

I observed that the log level of the handler needed to be set to TRACE for tracing to work when the log level of the category was set to TRACE. Changing the log level of the category up from TRACE to INFO worked fine.

Marker support is provided by a custom SLF4J extension logger that simply appends the name of the marker to the message text. However, there is a trade-off as the class and method names captured by the extended logger now refer to the MXLogger class and one of its methods.
