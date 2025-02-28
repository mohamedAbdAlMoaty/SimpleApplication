### APOD NASA Astronomy App

A Jetpack Compose app that fetches the latest astronomy data from NASA, implementing the MVVM architecture with Retrofit and Coil for best practices.

### Features
- MVVM Architecture
- Jetpack Compose UI Components
- Fetching NASA's APOD Data
- StateFlow for Live Data Updates
- Navigation with Jetpack Navigation Component

### Dependencies
- Jetpack Compose	Modern UI Framework
- Retrofit	API Calls
- Coil	Image Loading 
- Navigation Component	Screen Navigation
- Gson
- Coroutines & StateFlow	Live Data Management

### Supported Android Versions
- App supports devices running Android 7.0 (API 24) and above.
- It is optimized for Android 13 (API 33).

### Troubleshooting  
- **Issue:** When `imageUrl` is `null`, our app displays a **default image** stored locally.  
- Ensure you have entered a **valid API key** in `ApiConstants.kt`.  
- Check [NASA API Key Limits](https://api.nasa.gov/) to avoid restrictions.  
- Ensure **Internet connection** and that the following permission is added in `AndroidManifest.xml`

## Author
Mohamed Gowid

License
--------


    Copyright 2025 Mohamed Gowid.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
