# JBoss-SLF4J
Use the SLF4J logging facade over the built-in JBoss logging mechanism

The extended logger can be used by 1) adding org.slf4j.ext in the dependencies section of the manifest
and 2) adding a similar dependency in the jboss-deployment-structure document.

I also added org.slf4j to the dependencies section of the manifest but don't think it was required.
