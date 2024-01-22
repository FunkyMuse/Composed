Make sure to migrate to [KAHelpers Compose](https://github.com/FunkyMuse/KAHelpers/tree/main/compose) it's just different package name, everything remains the same.

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
composed-core-m3 = { module = "com.github.FunkyMuse.Composed:core-m3", version.ref = "composed" }
composed-placeholder = { module = "com.github.FunkyMuse.Composed:placeholder", version.ref = "composed" }
composed-placeholder-m3 = { module = "com.github.FunkyMuse.Composed:placeholder-m3", version.ref = "composed" }

#Optionally
[bundles]
composed = [
    "composed-core",
    "composed-placeholder",
]
composed-m3 = [
    "composed-core-m3",
    "composed-placeholder-m3",
]
```
