DumbPosts (BETA)
----
Dumbpost is an android project that use `jsonplaceholder` Typicode's API to retrieve dump post from a fake api.
This is just an simple example About how to use Clean Architecture, MVP pattern, RxAndroid, Dagger2 and Retrofit in an Android App.

The project has the following layers:

* `Data`: contains the data source of the app, it has two packages: `net` and `storage`.
* `Domain`: contains the business logic of our app. It's our inner layer has no dependencies from other layers. It has `interactor`, `model`, and `repository`. 
* `Presentation`: contains the MVP layers, such presenters and ui (Activities, fragments, etc.)

Libraries
----
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Butterknife](https://github.com/JakeWharton/butterknife)
* [Dagger2](https://google.github.io/dagger/)
* [jsonplacehoder fake API](https://jsonplaceholder.typicode.com/)

Todo
----
- [ ] `injection` package should be inside of presentation.
- [ ] `model` package inside `domain` must be renamed `entities`.
- [ ] create another models inside `data`. `data models` and `domain entities` should be different classes for better scalability.
- [ ] creates tests for each layer.
- [ ] implements retrolambda.


License
=======

    Copyright 2017 Christopher Ventura

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.