# Project Search Sample

This is a simple MVVM Android app that displays a search field where the user can type
any search term and the same results are returned from a test API endpoint. The results 
are retrieved as the user types and cleared when the user clears the search field. 
These results are a product list which are clickable and on click navigates the user to the detail
screen for the selected product.

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