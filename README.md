# Android Firebase Kotlin App

A modern Android application built with Kotlin and Firebase, featuring real-time data synchronization using Cloud Firestore.

## 🚀 Features

- **Real-time Data Sync**: Leverages Firebase Firestore for real-time database operations
- **Modern UI**: Built with Material Design principles
- **Authentication**: Secure user authentication with Firebase Auth
- **Offline Support**: Works seamlessly offline with local data caching
- **Cloud Storage**: File and image storage using Firebase Storage
- **Push Notifications**: Real-time notifications via Firebase Cloud Messaging (FCM)

## 🛠 Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Firebase Firestore
- **Authentication**: Firebase Authentication
- **Storage**: Firebase Cloud Storage
- **Notifications**: Firebase Cloud Messaging
- **UI Framework**: Android Jetpack Components
- **Dependency Injection**: Hilt/Dagger
- **Asynchronous Programming**: Coroutines & Flow

## 📋 Prerequisites

Before running this project, make sure you have:

- Android Studio Arctic Fox or later
- Kotlin 1.8.0 or later
- Android SDK API level 21 or higher
- Google Services JSON file from Firebase Console

## 🔧 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/PrasetyoWibowoo/your-app-name.git
   cd your-app-name
   ```

2. **Set up Firebase**
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project or use an existing one
   - Add an Android app to your project
   - Download the `google-services.json` file
   - Place it in the `app/` directory

3. **Enable Firebase Services**
   - Authentication (Email/Password, Google Sign-In)
   - Cloud Firestore
   - Cloud Storage
   - Cloud Messaging (optional)

4. **Open in Android Studio**
   - Open the project in Android Studio
   - Sync the project with Gradle files
   - Run the app on an emulator or physical device

## 🏗 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/yourpackage/
│   │   │   ├── data/
│   │   │   │   ├── model/          # Data models
│   │   │   │   ├── repository/     # Repository pattern
│   │   │   │   └── remote/         # Firebase operations
│   │   │   ├── ui/
│   │   │   │   ├── activities/     # Activities
│   │   │   │   ├── fragments/      # Fragments
│   │   │   │   ├── adapters/       # RecyclerView adapters
│   │   │   │   └── viewmodels/     # ViewModels
│   │   │   ├── utils/              # Utility classes
│   │   │   └── di/                 # Dependency injection
│   │   ├── res/
│   │   │   ├── layout/             # XML layouts
│   │   │   ├── values/             # Colors, strings, styles
│   │   │   └── drawable/           # Images and drawables
│   │   └── AndroidManifest.xml
│   └── google-services.json
├── build.gradle
└── README.md
```

## 🔥 Firebase Configuration

### Firestore Rules Example
```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Users can only access their own data
    match /users/{userId} {
      allow read, write: if request.auth != null && request.auth.uid == userId;
    }
    
    // Public collections (adjust as needed)
    match /public/{document=**} {
      allow read: if true;
      allow write: if request.auth != null;
    }
  }
}
```

### Storage Rules Example
```javascript
rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if request.auth != null;
    }
  }
}
```

## 📚 Key Dependencies

```kotlin
dependencies {
    // Firebase BOM
    implementation platform('com.google.firebase:firebase-bom:32.2.2')
    
    // Firebase services
    implementation 'com.google.firebase:firebase-auth-ktx'
    implementation 'com.google.firebase:firebase-firestore-ktx'
    implementation 'com.google.firebase:firebase-storage-ktx'
    implementation 'com.google.firebase:firebase-messaging-ktx'
    
    // Android Jetpack
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.6.0'
    implementation 'androidx.recyclerview:recyclerview:1.3.0'
    
    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'
    
    // Image loading
    implementation 'com.github.bumptech.glide:glide:4.15.1'
}
```

## 🚦 Usage

### Authentication
```kotlin
// Sign in with email and password
auth.signInWithEmailAndPassword(email, password)
    .addOnCompleteListener { task ->
        if (task.isSuccessful) {
            // Sign in success
            val user = auth.currentUser
        } else {
            // Sign in failed
        }
    }
```

### Firestore Operations
```kotlin
// Add data to Firestore
val user = hashMapOf(
    "first" to "Ada",
    "last" to "Lovelace",
    "born" to 1815
)

db.collection("users")
    .add(user)
    .addOnSuccessListener { documentReference ->
        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
    }
    .addOnFailureListener { e ->
        Log.w(TAG, "Error adding document", e)
    }
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**PrasetyoWibowoo**
- GitHub: [@PrasetyoWibowoo](https://github.com/PrasetyoWibowoo)
- Email: wibowoprasetyo40@gmail.com

## 🙏 Acknowledgments

- [Firebase Documentation](https://firebase.google.com/docs)
- [Android Developers](https://developer.android.com/)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Material Design](https://material.io/design)

## 📞 Support

If you have any questions or need help, please:
- Open an issue in this repository
- Contact me via email
- Check the [Firebase documentation](https://firebase.google.com/docs)

---

⭐ Don't forget to star this repository if you found it helpful!
