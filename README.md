# <img src="http://atlanmod.github.io/Mogwai/resources/Mogwai_logo.png" width="70" />&nbsp;Mogwaï

Mogwaï is an efficient and scalable query framework that takes benefits of Graph database query facilities to perform queries over [NeoEMF](https://github.com/atlanmod/NeoEMF) models.

It relies on a model-to-model transformation from OCL to Gremlin, the [Tinkerpop](http://www.tinkerpop.com/) query language to manipulate [Blueprints](https://github.com/tinkerpop/blueprints/wiki) compliant databases.
Generated Gremlin traversals are computed on the database side, bypassing limitations of EMF API and improving execution time and memory consumption performances.

Mogwaï is fully integrated in NeoEMF, and provides its own [PersistentResource](https://github.com/atlanmod/NeoEMF/blob/master/core/src/main/java/fr/inria/atlanmod/neoemf/resources/PersistentResource.java) extension which augment the default one with a [basic query API](https://github.com/atlanmod/Mogwai/blob/master/core/src/main/java/fr/inria/atlanmod/mogwai/resources/MogwaiResource.java). This API can be used to provide OCL queries (both inline or file-based) to Mogwaï, that will translate them into the appropriate Gremlin expression(s) and return results reified into navigable EObjects if needed.

## News: Validation Benchmark

We have developed a new model validation engine to improve the evaluation of constraints over large models, and reduce the time required to retrieve the instances to validate. You can validate an entire model by using the `MogwaiResource#validate` method, that will optimize the input OCL constraint and translate it into an efficient Gremlin script.

You can run the validation benchmarks from the [benchmarks project](https://github.com/atlanmod/Mogwai/tree/master/benchmarks/fr.inria.atlanmod.mogwai.benchmarks/src/fr/inria/atlanmod/mogwai/benchmark/validation). Note that you first need to run the `ModelMutator` application, that will create a mutated version of the benchmark models containing elements violating the benchmarked constraints. You can then run the different queries in the package. There are 3 variants of each query: QueryName_OCL (standard OCL computation), QueryName_StandardMogwai (standard `allInstances` and Mogwai translation of the constraint) and QueryName_OptimizedMogwai (constraint pre-processing and optimized translation).

## Installation
  You can download the last version of the update site [here](). NeoEMF ([v1.0.2](https://atlanmod.github.io/NeoEMF/releases/latest/plugin/) or newer), ATL (v3.8.0 or newer), EMFTVM ([v4.0.0](http://marketplace.eclipse.org/node/609049) or newer), OCL.ecore (v3.3.100), and OCL Examples and Editors SDK (v6.3.0 or newer) have to be installed in your Eclipse environment to run Mogwaï.

  Alternatively, you can get a copy of Mogwaï into your Eclipse workspace by following these instructions:
  * Clone the repository
  * Install IvyDE
  * Import the following projects in your workspace: fr.inria.atlanmod.mogwai.*
  * You can also build the update site locally by importing fr.inria.atlanmod.mogwai.update

## Documentation
Online [javadoc](https://atlanmod.github.io/Mogwai/documentation/index.html) corresponding to the latest build on [atl2gremlin branch](https://github.com/atlanmod/Mogwai/tree/atl2gremlin).

## Issues

The current version of Mogwaï (v0.0.1) is a prototype developed to assess the OCL-to-Gremlin transformation we have presented [here](https://hal.archives-ouvertes.fr/hal-01344019/file/document.pdf), and the ATL-to-Gremlin extension presented [here](https://hal.archives-ouvertes.fr/hal-01589582/document). Bugs and wrong translation of complex expressions may occur, and the repository is regularly updated with bug fixes and enhancements.

If you have problems running Mogwaï or if your input query is not translated properly, please submit an issue on the [issue tracker](https://github.com/atlanmod/Mogwai/issues)
