# DDS (Desk Dock Smart)
## Phase 1: Weather.
1. The application is a simple Android application which is written by Java/Kotlin.
2. The application is able to retrieve the weather information from OpenWeatherMaps
API.
3. The application is able to allow user to input the searching term.
4. The application is able to proceed searching with a condition of the search term length
must be from 3 characters or above.
5. The application is able to render the searched results as a list of weather items.
6. The application is able to support caching mechanism so as to prevent the app from
generating a bunch of API requests.
7. The application is able to manage caching mechanism & lifecycle.
8. The application is able to handle failures.
9. The application is able to support the disability to scale large text for who can't see the
text clearly.

10.The application is able to support the disability to read out the text using VoiceOver
controls.

### ----------------------------------------------------------------------------------------------

## Clean Architecture


### ----------------------------------------------------------------------------------------------

## UI Layer: MVVM
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_architecture_reloaded_mvvm_app.png)

### ----------------------------------------------------------------------------------------------

## Data Layer: Repository
![https://fernandocejas.com/2018/05/07/architecting-android-reloaded/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture-Kotlin/architecture/clean_archictecture_reloaded_repository.png)

### ----------------------------------------------------------------------------------------------

## Languages, libraries and tools used

   * [Kotlin](https://kotlinlang.org/)
   * Android Support Libraries
   * [Koin](https://insert-koin.io/)
   * [Corountine](https://github.com/google/dagger)
   * [Retrofit](http://square.github.io/retrofit/)
   * [OkHttp](http://square.github.io/okhttp/)
   * [Gson](https://github.com/google/gson)
   * [Robolectric](http://robolectric.org/)
   * [JUnit 4](http://robolectric.org/)
