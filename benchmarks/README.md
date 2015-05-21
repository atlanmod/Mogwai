# Mogwaï Benchmarks

## Installation

    To run Mogwaï Benchmarks, you first need to install Mogwaï following the [installation instructions](https://github.com/atlanmod/Mogwai/blob/master/README.md)
    then import the following projects from the benchmark folder:
    * fr.inria.atlanmod.mogwai.benchmarks: core of the benchmarks
    * fr.inria.atlanmod.mogwai.incquery.queries: generated queries from IncQuery partterns
    * org.eclipse.gmt.modisco.java, org.eclipse.gmt.modisco.java.cdo, org.eclipse.gmt.modisco.java.neoemf: generated code from Java Metamodel
    You also need to have EMF-IncQuery and OCL Eclipse plugins installed to run the benchmarks.
    Launch the benchmarks using the class fr.inria.atlanmod.mogwai.benchmarks.Benchmarks as a JUnit test.
    
## JVM Argument
    
    The presented benchmarks have been executed over two memory configuration:
    * -Xmx8g
    * -Xmx250m
    In addition, the following parameters have been applied
    * -server
    * -XX:+UseConcMarkSweepGC
    
## Benchmark execution
    
    The benchmarks consist of a set of 4 queries processed by 3 different query frameworks:
    * Eclipse OCL
    * EMF-IncQuery
    * Mogwai
    The databases storing the models are constructed the first time the benchmarks is launched. This might take some time, depending on 
    your system configuration. It is recommanded to use a large JVM to avoid garbage collection problems during the database creation.