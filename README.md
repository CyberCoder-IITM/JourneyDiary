# JourneyDiary

A native Android app for logging travels and everyday moments as diary entries. Built with Kotlin, currently in early scaffold stage.

## Status

This is a fresh Android Studio scaffold, not yet a working diary app. The splash screen and app shell exist, but no diary functionality (creating, saving, viewing, or tagging entries) has been implemented. `MainActivity` currently renders a static "Hello World!" placeholder.

**Known issue:** `MainActivity`, not `SplashActivity`, is registered as the launcher activity in `AndroidManifest.xml`. The animated splash screen exists in code but is never shown on app launch — either add the `MAIN`/`LAUNCHER` intent filter to `SplashActivity` (and remove it from `MainActivity`), or wire up navigation from `MainActivity` to trigger it.

## Features

- Animated two-image splash screen (fade transition) built with `ImageView` alpha animations
- Runtime location permission request (`ACCESS_FINE_LOCATION`), laying groundwork for location-tagged entries
- Material Design theming with light/dark support (`values-night`)

**Planned:** diary entry creation and editing, local persistence, photo attachments, and location tagging per entry.

## Tech Stack

| | |
|---|---|
| Language | Kotlin |
| Min / Target / Compile SDK | 16 / 34 / 34 |
| UI | AndroidX AppCompat, ConstraintLayout, Material Components |
| Build | Gradle Kotlin DSL (`build.gradle.kts`), AGP 8.1.0 |
| Testing | JUnit 4, Espresso |

## Project Structure

```
app/src/main/
├── java/com/example/journeydiary/
│   ├── splash.kt          # SplashActivity: location permission + fade transition
│   └── MainActivity.kt    # Current launcher activity, placeholder UI
└── res/
    ├── layout/            # activity_main.xml, splashscreen.xml
    ├── drawable/           # splash.png, bg.png, launcher icon
    ├── animator/           # fade_in.xml, fade_out.xml
    └── values(-night)/     # strings, colors, themes
```

## Requirements

- Android Studio (Giraffe or newer recommended)
- JDK 8+
- Android SDK Platform 34

## Getting Started

1. Clone the repo and open it in Android Studio.
2. Let Gradle sync (dependencies resolve from Google and Maven Central).
3. Run on an emulator or device (`minSdk` 16+).

Or from the command line:

```bash
./gradlew assembleDebug
```

## Permissions

- `ACCESS_FINE_LOCATION` — requested on launch, ahead of location-based diary features that don't exist yet.

**Note:** the permission check in `SplashActivity` calls `checkSelfPermission()` unconditionally. That API requires SDK 23+, but `minSdk` is set to 16, so the app can crash on devices running Android 5.x/6.0 below API 23. Either raise `minSdk` to 23 or guard the call with a `Build.VERSION.SDK_INT` check.

## Roadmap

- [ ] Fix launcher activity so the splash screen actually shows
- [ ] Guard the location-permission check for `minSdk` < 23
- [ ] Diary entry data model + local persistence (e.g. Room)
- [ ] Entry creation/editing UI
- [ ] Photo attachments
- [ ] Location tagging per entry

## Contributing

Early-stage personal project. Issues and pull requests are welcome once core features land.

## License

No license specified yet.
