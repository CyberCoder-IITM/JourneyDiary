# JourneyDiary

A native Android app for logging your travels and everyday moments as diary entries. Built with Kotlin and currently in early scaffold stage.

## Status

This project is a fresh Android Studio scaffold. The splash screen and app shell are wired up, but diary features (creating, saving, and viewing entries) are not yet implemented. `MainActivity` currently renders a placeholder screen.

## Features

- Animated splash screen that transitions into the main screen
- Runtime location permission request (`ACCESS_FINE_LOCATION`), laying the groundwork for location-tagged entries
- Material Design theming (light/dark support via `values-night`)

**Planned:** diary entry creation and editing, local persistence, photo attachments, and location tagging per entry.

## Tech Stack

- Kotlin
- Android SDK (min 16, target/compile 34)
- AndroidX: AppCompat, Core-KTX, ConstraintLayout, Material Components
- Gradle Kotlin DSL (`build.gradle.kts`)
- JUnit + Espresso for testing

## Project Structure

```
app/
  src/main/
    java/com/example/journeydiary/
      SplashActivity.kt   # Splash screen + location permission + transition animation
      MainActivity.kt     # Main app entry point
    res/
      layout/             # activity_main.xml, splashscreen.xml
      values/             # strings, themes, colors
```

## Requirements

- Android Studio (Giraffe or newer recommended)
- JDK 8+
- Android SDK Platform 34

## Getting Started

1. Clone the repo and open it in Android Studio.
2. Let Gradle sync (dependencies resolve from Google and Maven Central).
3. Run the app on an emulator or device (`minSdk` 16+).

Or from the command line:

```bash
./gradlew assembleDebug
```

## Permissions

- `ACCESS_FINE_LOCATION` — requested on launch for future location-based diary features.

## Contributing

This is an early-stage personal project. Issues and pull requests are welcome once core features land.

## License

No license specified yet.
