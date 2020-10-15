# Bootstrap shared properties

A toy example to demonstrate the problem from [this SO post](https://stackoverflow.com/questions/64355183/sharing-properties-between-bootstrap-configurations).


## Core places:

### `com.example.demo.libx.LibXPropertySourceLocator`

* Consumes: `libX.consumed.property`

* Produces: `libX.produced.property`

### `com.example.demo.liby.LibYPropertySourceLocator`
 
* Consumes: `libY.consumed.property`

* Produces: `libY.produced.property`


### `com.example.demo.Main.Printer`

* Prints `libX.produced.property` and `libY.produced.property`


### `src/main/resources/bootstrap.properties` 

Provides values for:

* `libX.consumed.property`
* `libY.consumed.property`

Works when values are independent.

E.g.
```
libX.consumed.property=15
libY.consumed.property=25
```

No longer works when one value depends on a property provided by another library. 

E.g.

```
libX.consumed.property=15
libY.consumed.property=${libX.produced.property}
```
