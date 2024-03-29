## Проект реализации приложения Инстаграм


### Задача
- Реализация приложения Инстаграмм.

### Функционал приложения: 
- Регистрация и аутентификация
- Аутентифицированный пользователь может создавать посты с фото-вложениями,
редактировать и удалять их, а также лайкать фотографии других пользователей.
- Вожможность просмотра всех зарегистрированных пользователей.
- Реализована логика просмотра профиля каждого пользователя с отображением всех его постов.
- Реализована логика списка избранных фотографий.
- "Проигрывание" медиа-вложений (для изображений - показ, для аудио и видео - воспроизведение).
-  Переход по внешним ссылкам (поля link, если ссылаются на внешние ресурсы).
- Темная и светлая темы

### Скриншоты:

- Экран профиля
![Screenshot1]

- Экран списка событий 
![Screenshot2]

- Экран списка постов
![Screenshot3]


Экран списка пользователей
![Screenshot4]


Экран регистрации
![Screenshot5]


### Реализация приложения
- Kotlin for all code
- Single Activity Application
- Navigation Component for Fragments
- MVVM for presentation layer
- Coroutines for async work
- Dagger 2 (Hilt) for DI
- Glide для загрузки изображений
- Material Components for styling UI components
- okhttp3 для сетевых запросов
- Room для хранения данных в БД
- Firebase for authorisation and authorization