# Mogwaï

Mogwaï is an efficient and scalable query framework that takes benefits of NoSql databases to perform queries over [NeoEMF](https://github.com/atlanmod/NeoEMF) models.

It relies on a model-to-model transformation from OCL to Gremlin, the [Tinkerpop](http://www.tinkerpop.com/) query language to manipulate [Blueprints](https://github.com/tinkerpop/blueprints/wiki) compliant databases.
Generated Gremlin traversals are computed on the database side, bypassing limitations of EMF API and improving execution time and memory consumption performances.

Mogwaï does not reify the query results into a navigable model, this task is left to the persistence framework embedding it. See NeoEMF resource documentation for query integration in NeoEMF.

## Installation
  There is no available update site for Mogwaï, it will be provided with the first release of the tool.
  To install Mogwaï, please follow this instructions:
  * Clone the repository
  * Import the following projects in your workspace: fr.inria.atlanmod.mogwai.gremlin, fr.inria.atlanmod.mogwai.transformation, fr.inria.atlanmod.mogwai.core

An update site will be available with the first release of the tool.

Eclipse m2e (maven plugin), ATL and NeoEMF plugins have to be installed in your Eclipse environment to run Mogwaï.

## Issues

If you have problems running Mogwaï or if you find a bug, please submit an issue on the [issue tracker](https://github.com/atlanmod/Mogwai/issues)
