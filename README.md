# Blok
A standalone minecraft server written in Kotlin

The theory behind Blok is that I wanted to have a minecraft server specifically designed for minigames.
Worlds only saving when you tell them to, no Entity AI (by default at least), things like that.
This way, we only do things if you **want** them to happen, nothing will happen without you telling it to.

Also, there are many features that some APIs are missing. Things such as entity-specific listeners,
a built-in API for fake entities, and things in that nature. These are some key features that I believe
should be available within the API of a minecraft server, rather than needing to go into the server implementation.