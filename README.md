# Project Search Sample

This is a simple MVVM Android app built in Kotlin that displays a search field where the user can type
any search term and the same results are returned from a test API endpoint - in other words the same
query parameters are always sent. The results are retrieved as the user types and cleared when the 
user clears the search field. These results are a list of products displayed below the search field to the user
which are clickable and on click navigates the user to the detail screen for the selected product.

<img src="https://user-images.githubusercontent.com/2282990/184181055-dfe6b76f-740d-4e84-ad79-766ab864ac75.gif" width="246"/>

## Architecture
This project is built in Kotlin and uses the following libraries:

- Jetpack Compose
- ViewModel, State and Kotlin Flow
- Rafael Costa's `Compose Destinations` library for navigation
- Hilt
- Compose Coil
- Compose Material 3
- Retrofit
- OkHttp

### Code and directory structure
```
[main]

> di
> domain
  > model
  > useCases
> network
  > model
> repository
> ui
  > components
  > main
  > navigation
  > productdetail
  > search
  > theme
> util
  |_ Constants.kt
|_ ProductSearchApp.kt
|_ MainActivity.kt

```

```
test [unitTest]

> domain
  > useCases
  |_ GetProductsUseCaseTest 
> network
  > model
  |_ NetworkProductTest
> repository
  |_ FakeSearchRepository

```

```
androidTest

> di
  |_ TestAppModule 
> ui
  |_ SearchScreenTest
HiltTestRunner

```

## The different directories

### di
This is the dependency injection package where Hilt modules are defined. This project
has three modules `AppModule`, `NetworkModule` and `RepositoryModule`

### domain
This package contains two subpackages - `model` and `useCases`. `model` is used to house
the app specific models modelled against the network models found in `network.model`.

The `useCases` contains `GetProductUseCase` whose role is to communicate to the repository
on behalf of the viewModel and retrieve the data to be displayed. `ProductUseCase` is a data
model to contain all the different use cases for the products.

### network
This package contains a subpackage `model` and Retrofit service definitions for 
connecting to the API. Hilt then provides these through the `di.NetworkModule` module.
The `model` package contains data classes modelled against the API's JSON response body.

### repository
This package contains the interface `SearchRepository` and its implementation class
`SearchRepositoryImpl`. `SearchRepositoryImpl` requires a data source which is provided via dependency
injection, and retrieves the data from the API and returns this as `Flow`.

### ui
The is where all the UI Compose code is. The `main` package contains the `MainScreen` composable
setup by `MainActivity` as the compose navigation host.

Using Rafael Costa's `Compose Destinations` library, the navigation graph is easily created
using annotated composables. `ui.search.SearchScreen` and `ui.productdetail.ProductDetailScreen`
are both annotated with `@Destination` and added at to the generated navigation graph. 

The `navigation` package contains the navigation host where the `Compose Destinations`'s 
`DestinationsNavHost` is used to set the navigation graph up.

The `search` and `productdetail` packages represent the only two screens displayed to the 
user, each with its own viewModel.

## Unit tests
The project contains tests for:

- the different use-cases for retrieving data from the repository layer contained
  in `GetProductsUseCaseTest`
- the response from the network layer is converted into domain entities
  through extension functions. Each of these functions is unit tested in
  `NetworkProductTest`

## UI Tests

The project contains instrumented tests which tests the `SearchScreen` composable
These tests are found in `SearchScreenTest`

## Setup

### Pre-requisites
It is important that you ensure that the below are fully setup or the project will not run.

### Java version
The project is configured to use Java 11. Please ensure that your Android Studio is set to use this and
not the default 1.8 else the project will not build:

```
Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK

```
<img width="981" alt="Screenshot 2022-08-10 at 18 35 09" src="https://user-images.githubusercontent.com/2282990/183965765-fc4034ff-45e0-4996-ac18-ca4682216f4d.png">


## License

MIT License

Copyright (c) 2022 Ahmed Tikiwa

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
