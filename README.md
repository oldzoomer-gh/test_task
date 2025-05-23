# Тестовое задание

Тестовое задание:  Базовая аутентификация для Telegram WebApp и отображение персональных данных

## Описание задачи

Вам необходимо реализовать базовую аутентификацию пользователей с использованием Spring Boot и Thymeleaf. После успешной аутентификации пользователь должен видеть свою персональную информацию, которую Telegram предоставляет при запуске WebApp.

## Требования

0. Сделайте собственного бота в Telegram, и получите токен. Токен должен хранится секретно
1. Аутентификация через Telegram:

* Реализовать валидацию и проверку срока действия данных, которые Telegram передает в initData (см. <https://core.telegram.org/bots/webapps#validating-data-received-via-the-mini-app>).
* _По желанию_: Проверять целостность данных с помощью HMAC-SHA256.

2. Spring Security:

* Настроить фильтр, который будет работать с cookie, в котором передадите данные, полученные от Telegram и создавать объект аутенификации
* _По желанию_: будет удобно, если вы реализуете свой UserDetails

3. Отображение данных/Контроллер:

* На главной странице (/) отобразить основные персональные данные пользователя, полученные из Telegram (id, first_name, last_name, username — в зависимости от того, что приходит).
* _По желанию_: Использовать Thymeleaf для отображения данных на странице
* _По огромному желанию: Использовать JTE для отображения данных на странице
* _По еще более огромному желанию: Использовать Tailwind для стилизации данных на странице

4. Обработка ошибок:

* Для неаутентифицированных пользователей показывать страницу с текстом

5. База данных:

* Не требуется

6. Тесты

* Хочу увидеть как минимум тестирование валидации данных initData
* _По желанию_: Протестировать контроллер

7. Развёртывание кода

* Во время разработки, Деплой вашего кода можно делать на любой удобный вам бесплатный сервис, либо через туннель.

8. Прочее

* По коммитам должна быть видна самостоятельная работа кандидата. Один коммит не сможет дать мне возможности оценить ход разработки.

## Что нужно сдать

* Ссылку на публичный репозиторий с рабочим решением.
* Рабочее решение – это такое решение, которое я могу склонировать, развернуть на сервере, и прикрепить сервер мини приложению для запуска, открыть его и увидеть данные
* Прислышаем мне в телеграм <https://t.me/e_mitrokhin>

## Сроки

* С одной стороны, чем раньше, тем лучше. С другой, не хочу вводить никого в стресс.
* Если вы не вывозите, то хотелось бы оперативно знать о вашем отказе
