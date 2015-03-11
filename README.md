# Mogwaï

Mogwaï is an efficient and scalable query framework that takes benefits of NoSql databases to perform queries over [NeoEMF](https://github.com/atlanmod/NeoEMF) models.

It relies on a model-to-model transformation from OCL to Gremlin, the [Tinkerpop](http://www.tinkerpop.com/) query language to manipulate [Blueprints](https://github.com/tinkerpop/blueprints/wiki) compliant databases.
Generated Gremlin traversals are computed on the database side, bypassing limitations of EMF API and improving execution time and memory consumption performances.

Mogwaï does not reify the query results into a navigable model, this task is left to the persistence framework embedding it. See NeoEMF resource documentation for query integration in NeoEMF.
