# <img src="http://atlanmod.github.io/Mogwai/resources/Mogwai_logo.png" width="70" />&nbsp;Mogwaï

Mogwaï is an efficient and scalable query framework that takes benefits of Graph database query facilities to perform queries over [NeoEMF](https://github.com/atlanmod/NeoEMF) models.

It relies on a model-to-model transformation from OCL to Gremlin, the [Tinkerpop](http://www.tinkerpop.com/) query language to manipulate [Blueprints](https://github.com/tinkerpop/blueprints/wiki) compliant databases.
Generated Gremlin traversals are computed on the database side, bypassing limitations of EMF API and improving execution time and memory consumption performances.

Mogwaï is fully integrated in NeoEMF, and provides its own [PersistentResource](https://github.com/atlanmod/NeoEMF/blob/master/core/src/main/java/fr/inria/atlanmod/neoemf/resources/PersistentResource.java) extension which augment the default one with a [basic query API](https://github.com/atlanmod/Mogwai/blob/master/core/src/main/java/fr/inria/atlanmod/mogwai/resources/MogwaiResource.java). This API can be used to provide OCL queries (both inline or file-based) to Mogwaï, that will translate them into the appropriate Gremlin expression(s) and return results reified into navigable EObjects if needed.

## Installation
  You can download the last version of the update site [here](). NeoEMF (v0.0.0), ATL (v3.5.0), and OCL.ecore (v3.3.100) have to be installed in your Eclipse environment to run Mogwaï.
  
  Alternatively, you can get a copy of Mogwaï into your Eclipse workspace by following these instructions:
  * Clone the repository
  * Install Eclipse m2e (maven plugin)
  * Import the following projects in your workspace: fr.inria.atlanmod.mogwai.gremlin, fr.inria.atlanmod.mogwai.transformation, fr.inria.atlanmod.mogwai.core
  * You can also build the update site locally by importing fr.inria.atlanmod.mogwai.update

## Issues

The current version of Mogwaï (v0.0.1) is a prototype developped to assess the transformation we presented [here](https://hal.archives-ouvertes.fr/hal-01344019/file/document.pdf). Bugs and wrong translation of complex OCL expression may occur, and the repository is regularly updated with bug fixes and enhancements.

If you have problems running Mogwaï or if your input query is not translated properly, please submit an issue on the [issue tracker](https://github.com/atlanmod/Mogwai/issues)
