# hibernate_example1
Простой пример работы с hibernate

Пример содержит работу с одной таблицей БД (выборка с помощью createQuery).
В качестве базы данных используется H2 (режим In-Memory). Структура базы и данные создаются при запуске программы из sql-скрипта.
Таким образом, нет необходимости создавать базу вручную  и прописывать к ней параметры соединения.
Программа готова к запуску "сразу" после сборки.
Собрать нужно maven-ом и запустить с помощью java -jar example1-1.0-SNAPSHOT.jar
