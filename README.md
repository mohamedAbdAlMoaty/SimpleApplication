🌌 APOD NASA Astronomy App

A Jetpack Compose app that fetches NASA's updated information about Astronomy, implementing MVVM architecture with Retrofit & Coil for best practices.
📜 Features

✅ MVVM Architecture (Separation of Concerns)
✅ Jetpack Compose UI (Modern UI Components)
✅ Retrofit API Calls (Fetching NASA's APOD Data)
✅ StateFlow for Live Data Updates
✅ Navigation with Jetpack Navigation Component

📂 Project Structure

com.example.simpleapplication
│── data
│   ├── model
│   │   ├── ApodItem.kt      # Data class for APOD items
│   ├── network
│   │   ├── ApodApiService.kt  # Retrofit API service
│   ├── repository
│   │   ├── ApodRepository.kt  # Handles API calls
│── viewmodel
│   ├── ApodViewModel.kt   # ViewModel for business logic
│── ui
│   ├── MainActivity.kt       # Entry point for the app
│   ├── ApodListScreen.kt     # Displays list of APODs
│   ├── ApodDetailScreen.kt   # Shows APOD details
│   ├── ApodItemRow.kt        # Single item UI component
│── navigation
│   ├── NavGraph.kt         # Navigation between screens
│── utils
│   ├── ApiConstants.kt    # Stores API-related constants


### Dependencies
- Jetpack Compose	Modern UI Framework
- Retrofit	API Calls
- Coil	Image Loading 
- Navigation Component	Screen Navigation
- Gson
- Coroutines & StateFlow	Live Data Management

### Supported Android Versions
✅ Your app supports devices running Android 7.0 (API 24) and above.
✅ It is optimized for Android 13 (API 33).

🔍 Troubleshooting
🚫 Issue: API Key Not Working

    Ensure you have entered a valid API key in ApiConstants.kt.
    Check NASA API Key Limits.
    Ensure Internet connrection and Permission is added in AndroidManifest.xml


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
