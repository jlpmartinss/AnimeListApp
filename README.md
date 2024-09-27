# Anime Explorer

**Anime Explorer** is an Android app that consumes the [Kitsu Anime API](https://kitsu.docs.apiary.io/#reference/anime) to display trending anime and detailed anime information. 
The app uses **MVVM architecture**, **Dagger Hilt** for dependency injection, and **Jetpack Compose** for the UI.

## Screenshots
![Screenshot 2024-09-10 at 01 48 02](https://github.com/user-attachments/assets/2dd112cb-f9c9-42ef-8f4a-7d24e8b2bb70)
![Screenshot 2024-09-10 at 01 49 13](https://github.com/user-attachments/assets/e8abcfd4-b1bc-4fb2-be8f-66e175c56e77)
### AnimeScreen
The **AnimeScreen** shows detailed information about an anime, including:
- Synopsis
- Year
- Rating
- Cover Image

### TrendingAnimeListScreen
The **TrendingAnimeListScreen** displays a list of trending anime, each showing:
- Title
- Rating
- Image

## Features

- **Trending Anime List**: Displays a list of currently trending anime with basic information.
- **Anime Details**: Detailed information about each anime, including synopsis, year, and rating.
- **Offline Support**: Uses Room Database for caching to provide offline support.
- **Search Functionality**: Search for anime titles in the trending list.

## Technologies Used

- **Kotlin**: The entire app is written in Kotlin.
- **Jetpack Compose**: Modern UI framework used for creating the user interface.
- **MVVM (Model-View-ViewModel)**: To ensure separation of concerns, making the app scalable and maintainable.
- **Dagger Hilt**: Dependency injection library used for managing app dependencies.
- **Retrofit**: Used for making HTTP requests to the Kitsu API.
- **Moshi**: A library used for JSON serialization/deserialization with Retrofit.
- **OkHttp**: Used as the HTTP client, with logging interceptors for debugging network calls.
- **Coil**: For loading images from URLs into the UI.

## Build and Project Setup

### Project Structure
This project uses **Jetpack Compose** for UI and follows the **MVVM** architecture. The key libraries and frameworks used include:

- **Dagger Hilt** for dependency injection.
- **Retrofit** and **Moshi** for API calls and JSON parsing.
- **Coil** for image loading.

## Getting Started

### Prerequisites
- Android Studio (Latest version)
- Kotlin 1.8+
- JDK 11

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/jlpmartinss/AnimeListApp
   ```
2. Open the project in **Android Studio**.
3. Sync the project to download necessary dependencies.
4. Run the app on an emulator or physical device.

## How It Works

The app fetches the latest trending anime using the **Kitsu Anime API**. The data is displayed in the **TrendingAnimeListScreen**. When an anime is selected, the app navigates to the **AnimeScreen** to display detailed information.

### API Reference

For more information on the Kitsu API, visit the [API Documentation](https://kitsu.docs.apiary.io/#reference/anime).

## Contributing

Feel free to fork this repository and contribute by submitting pull requests.

## License

This project is licensed under the MIT License.
