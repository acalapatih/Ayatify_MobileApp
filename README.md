[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/acalapatih/Ayatify_MobileApp">
    <img src="image/logo_ayatify.png" alt="Logo" width="200" height="200">
  </a>

  <h1 align="center">Ayatify Mobile App</h1>

  <p align="center">
    A great application that can enhance Quran memorization.
    <br />
    <a href="https://github.com/acalapatih/Ayatify_MobileApp"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/acalapatih/Ayatify_MobileApp">View Demo</a>
    ·
    <a href="https://github.com/acalapatih/Ayatify_MobileApp/issues">Report Bug</a>
    ·
    <a href="https://github.com/acalapatih/Ayatify_MobileApp/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#introduction">Introduction</a></li>
    <li><a href="#mock-up">Mock Up</a></li>
    <li><a href="#features">Features</a></li>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#build-with">Build With</a></li>
        <li><a href="#project-structure">Project Structure</a></li>
      </ul>
    </li>
  </ol>
</details>

## Introduction
Ayatify applies Speech To Text technology with the One Day One Ayat Method to facilitate independent Quran memorization submissions. Additionally, this application also provides the entire Quran text that can be read and saved for bookmarking purposes.

## Mock Up
<img src="image/fitur_utama.png" alt="Main Feature">

### Quran Recitation Feature
<img src="image/baca_quran.png" alt="Quran Recitation Feature">

### Quran Memorization Feature
<img src="image/hafalan_quran.png" alt="Quran Memorization Feature">

### Reminder Notification Feature
<img src="image/notifikasi_pengingat.png" alt="Reminder Notification Feature">

## Features
- Splash Screen
- Read the Quran and its Translation
- Quran Memorization Submission
- Quran Memorization Detection
- Reminder Notifications
- Verse Bookmarking
- Memorization Status
 
## About The Project
### Build With
- [Lifecycle & Livedata](https://developer.android.com/guide/components/activities/activity-lifecycle?hl=id)
- [Retrofit](https://square.github.io/retrofit/)
- [Room](https://developer.android.com/codelabs/android-room-with-a-view-kotlin)
- [Navigation Component](https://developer.android.com/guide/navigation/get-started)
- [Notification Manager](https://developer.android.com/reference/android/app/NotificationManager)
- [Kotlin Coroutines](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiU2bPz88f_AhXVk2YCHXdgDDMYABAAGgJzbQ&ohost=www.google.com&cid=CAESbOD2gWGIEaIzh7xPUOGICyK2tbXIr0QUhhlGSrurjKcD6swxwpKj-7IrQ9_iwmDhml1_P_z6seVQZZNvkJ-fiMxTpf1xONyVn40ucS143xA8HR8Y35CCv_06CgyhYufQQc6JFf2g1WPjknZFow&sig=AOD64_1YR8UhDwd6LH3WrvCacezcHvoFUw&q&adurl&ved=2ahUKEwiUqKzz88f_AhUT7TgGHSukAJEQ0Qx6BAgIEAE)
- [Ok Http 3](https://square.github.io/okhttp/)
- [GSON](https://github.com/google/gson)
- [Fragment](https://developer.android.com/guide/fragments?hl=id)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=id)
- [Koin](https://insert-koin.io/)
- [Google Speech API](https://cloud.google.com/speech-to-text)

### Project Structure
- core
  - data
    - repositoryImpl
    - source
      - local
      - remote
  - di
    - AppModule.kt
  - domain
    - interactor
    - model
    - repository
    - usecase
- ui
- utils

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/acalapatih/Ayatify_MobileApp.svg?style=for-the-badge
[contributors-url]: https://github.com/acalapatih/Ayatify_MobileApp/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/acalapatih/Ayatify_MobileApp.svg?style=for-the-badge
[forks-url]:https://github.com/acalapatih/Ayatify_MobileApp/network/members
[stars-shield]: https://img.shields.io/github/stars/acalapatih/Ayatify_MobileApp.svg?style=for-the-badge
[stars-url]: https://github.com/acalapatih/Ayatify_MobileApp/stargazers
[issues-shield]: https://img.shields.io/github/issues/acalapatih/Ayatify_MobileApp.svg?style=for-the-badge
[issues-url]: https://github.com/acalapatih/Ayatify_MobileApp/issues
[license-shield]: https://img.shields.io/github/license/acalapatih/MobilePQI_mobileApp.svg?style=for-the-badge
[license-url]: https://github.com/acalapatih/Ayatify_MobileApp/blob/main/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/amir-acalapati-henry
