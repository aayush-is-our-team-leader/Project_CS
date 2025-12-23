# NativeJavaApp
Scaffold for creating double-clickable apps using Java

This project uses Apache Ant and JDK 25 to compile, bundle, and package a Java application into native installers (.dmg for macOS and .deb for Ubuntu).

## Common Requirements (All Systems)
Before running the build, ensure the following are installed and configured:
- JDK 21 or 25: Must be installed. jpackage was introduced in JDK 14, but JDK 21+ is recommended for modern macOS/Linux support.
- Apache Ant: Installed and available in your PATH.
- JAVA_HOME: This environment variable must point to your JDK installation directory.
  - Check via: ant -version and java -version
## macOS Setup
To build the .dmg installer, your Mac needs the following:
- Xcode Command Line Tools: Required for various build utilities.
  - Install via: xcode-select --install
- Icon Asset: A file named icon.icns must be in the project root.
- Note on Security: Since the app is not "Signed" with an Apple Developer Certificate, users may need to Right-Click > Open the app the first time to bypass the "Unidentified Developer" warning.
## Ubuntu / Debian Setup
To build the .deb package on Linux, jpackage requires external tools to create the Debian archive structure.

Run the following command to install the necessary packaging dependencies:

```Bash
sudo apt update
sudo apt install ant fakeroot dpkg-dev
```
- fakeroot: Allows the package to be built with correct file permissions without requiring root access.
- dpkg-dev: Provides the core utilities to create Debian packages.
- Icon Asset: A file named icon.png (512x512 recommended) must be in the project root.
## Project Directory Structure
Ensure your project looks like this for the build.xml to find all resources:

```Plaintext
MyAntApp/
├── src/
│   └── Main.java       # Your source code
├── icon.icns           # Required for macOS DMG
├── icon.png            # Required for Ubuntu DEB
└── build.xml           # The Ant build script
```
## Usage Commands
Open your terminal in the project root and use the following targets:

| Command |	Description |
|-----|-----|
| ant |	The default; runs the package target. |
| ant package |	Automatically detects OS and builds .dmg (Mac) or .deb (Linux). |
| ant run	| Compiles and launches the app immediately for testing. |
| ant clean	| Deletes the build/ and dist/ folders to start fresh. |
| ant -p	| Displays a help menu of all available targets. |
## Troubleshooting
<table>
  <tr>
    <td>"jpackage&nbsp;not&nbsp;found": </td>
    <td>Ensure your JAVA_HOME is set to a JDK version 14 or higher. The jpackage binary resides in $JAVA_HOME/bin/.</td>
  </tr>
  <tr>
    <td>Linux Icon Error: </td>
    <td>If the Linux build fails, ensure icon.png is not just a renamed .icns or .jpg. It must be a valid PNG file.</td>
  </tr>
  <tr>
    <td>Permissions: </td>
    <td>If the generated .app or .deb won't execute, ensure you have the necessary write permissions in the dist/ directory.</td>
  </tr>
</table>
