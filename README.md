# Composed
Helpers for smoother Compose development on Android

# Include
[![](https://jitpack.io/v/FunkyMuse/Composed.svg)](https://jitpack.io/#FunkyMuse/Composed)

```toml
[versions]
composed = "" #check latest version

[libraries]
#Composed
composed-core = { module = "com.github.FunkyMuse.Composed:core", version.ref = "composed" }
composed-navigation = { module = "com.github.FunkyMuse.Composed:navigation", version.ref = "composed" }

#Optionally
[bundles]
composed = [
    "composed-core",
    "composed-navigation",
]
```