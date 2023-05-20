# Простая банковская система
## Пятый проект от HyperSkill.org
```HTML
https://hyperskill.org/projects/93?category=2&track=12
```
## Оглавление
- [Описание](#описание)
- [Особенности](#особенности)
- [Использование](#использование)
- [Обратная связь] (#обратная связь)2. Follow the on-screen instructions: The program will display a menu with different options. Enter the corresponding number to perform the desired action.
3. 
## Feedback
During this project, I learned about the functioning of a banking system and gained knowledge about SQL and databases. Understanding how the Luhn algorithm works was particularly valuable in preventing errors when entering card numbers. Additionally, I grasped basic object-oriented programming concepts, such as working with classes.

While working on the project, I encountered a few difficulties. Setting up and connecting to the database required some effort, but I was able to overcome it by studying the documentation and seeking guidance from online resources. Designing the system to handle various banking operations and ensuring data security also posed challenges, but careful planning and research helped me overcome these obstacles.

Overall, this project provided me with a practical understanding of banking systems and allowed me to develop my skills in working with databases, SQL, and object-oriented programming. It was a valuable learning experience that enhanced my knowledge and problem-solving abilities.

## Contributing
Contributions to the Simple Banking System project are welcome. If you would like to contribute, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your modifications.
4. Test your changes to ensure they work as intended.
5. Commit your changes and push them to your forked repository.
6. Submit a pull request, describing the changes you made and their purpose.

## Dependencies
The Simple Banking System project has the following dependencies:

1. Java Development Kit (JDK): Ensure that you have a compatible JDK installed. Make sure you have JDK version 17.0 or higher installed. You can download the latest JDK from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/#java17).
2. SQLite JDBC Driver: Obtain the driver from a reliable source and include it in the project's classpath. The recommended version is 3.41.2. You can download the JDBC driver from the [SQLite JDBC Driver website](https://github.com/xerial/sqlite-jdbc/releases) or include it as a Maven/Gradle dependency.

## Contact Information
If you have any questions or concerns regarding the Simple Banking System project, please contact the project maintainer:
- Name: ```Serik Makzhanov```
- Email: ```serik.makzhanov@gmail.com```
- [Внесение вклада](#внесение вклада)
- [Зависимости](#зависимости)
- [Контактная информация](#контактная информация)

## Описание
Это  проект простой банковской системы, реализованный на Java. Цель проекта - дать базовое представление о том, как работает банковская система, наряду с практическим опытом работы с базами данных и SQL. Он также знакомит с фундаментальными концепциями объектно-ориентированного программирования (ООП) посредством использования классов.

## Особенности
Даный проект предлагает следующие функции:
1. Создание учетной записи: Пользователи могут создать новую учетную запись, которая включает в себя генерацию уникального номера карты, который проходит проверку алгоритмом Луна, и PIN-кода.
2. Вход в учетную запись: Пользователи могут войти в свои учетные записи, используя существующий в базе данных номер карты и PIN-код.
3. Запрос баланса: Вошедшие в систему пользователи могут проверить баланс на счету свой учетной записи в бзе данных.
4. Добавление суммы на счет: Вошедшие в систему пользователи могут добавлять сумму на счет своей учетной записи.
5. Перевод средств: Вошедшие в систему пользователи могут переводить средства с баланса своей учетной записи на баланс другой, существующей в базе данных, учетной записи.
6. Закрытие учетной записи: Вошедшие в систему пользователи могут закрыть (удалить из базы данных) свою учетную запись.

## Использование
### Чтобы запустить проект Simple Banking System, выполните следующие действия:

1. Настройте базу данных: В проекте используется база данных SQLite. Убедитесь, что установлен драйвер SQLite JDBC.
2. Загрузите файлы проекта: Клонируйте файлы проекта или получите их по предоставленной ссылке.
3. Скомпилируйте проект: Скомпилируйте классы Java с помощью компилятора Java.
4. Запустите проект: Запустите скомпилированный основной класс, указав необязательный аргумент командной строки -fileName, чтобы указать имя файла базы данных. Если имя файла не указано, будет использоваться имя файла по умолчанию.
5. Следуйте инструкциям на экране: Программа отобразит меню с различными опциями. Введите соответствующий номер, чтобы выполнить желаемое действие.

### Чтобы создать JAR-файл для проекта Simple Banking System, выполните следующие действия:
1. Скомпилируйте проект: Скомпилируйте классы Java с помощью компилятора Java.
2. Создайте файл манифеста: Создайте текстовый файл с именем manifest.txt и добавьте следующий контент:
```shell
Main-Class: Main
```
3. Создайте файл JAR: откройте терминал или командную строку, перейдите в каталог, содержащий скомпилированные классы и manifest.txt файл и выполните следующую команду:
4. The SimpleBankingSystem.jar файл будет создан в текущем каталоге.

### Чтобы запустить JAR-файл, выполните следующие действия:
1. Запустите JAR-файл: Введите следующую команду для запуска JAR-файла:
```shell
java -jar Project5SimpleBankingSystem-1.0-SNAPSHOT.jar2. Follow the on-screen instructions: The program will display a menu with different options. Enter the corresponding number to perform the desired action.
3. 
## Feedback
During this project, I learned about the functioning of a banking system and gained knowledge about SQL and databases. Understanding how the Luhn algorithm works was particularly valuable in preventing errors when entering card numbers. Additionally, I grasped basic object-oriented programming concepts, such as working with classes.

While working on the project, I encountered a few difficulties. Setting up and connecting to the database required some effort, but I was able to overcome it by studying the documentation and seeking guidance from online resources. Designing the system to handle various banking operations and ensuring data security also posed challenges, but careful planning and research helped me overcome these obstacles.

Overall, this project provided me with a practical understanding of banking systems and allowed me to develop my skills in working with databases, SQL, and object-oriented programming. It was a valuable learning experience that enhanced my knowledge and problem-solving abilities.

## Contributing
Contributions to the Simple Banking System project are welcome. If you would like to contribute, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your modifications.
4. Test your changes to ensure they work as intended.
5. Commit your changes and push them to your forked repository.
6. Submit a pull request, describing the changes you made and their purpose.

## Dependencies
The Simple Banking System project has the following dependencies:

1. Java Development Kit (JDK): Ensure that you have a compatible JDK installed. Make sure you have JDK version 17.0 or higher installed. You can download the latest JDK from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/#java17).
2. SQLite JDBC Driver: Obtain the driver from a reliable source and include it in the project's classpath. The recommended version is 3.41.2. You can download the JDBC driver from the [SQLite JDBC Driver website](https://github.com/xerial/sqlite-jdbc/releases) or include it as a Maven/Gradle dependency.

## Contact Information
If you have any questions or concerns regarding the Simple Banking System project, please contact the project maintainer:
- Name: ```Serik Makzhanov```
- Email: ```serik.makzhanov@gmail.com```
```
2. Следуйте инструкциям на экране: Программа отобразит меню с различными опциями. Введите соответствующий номер, чтобы выполнить желаемое действие.

## Обратная связь
Во время этого проекта я узнал о функционировании банковской системы и приобрел знания о SQL и базах данных. Понимание того, как работает алгоритм Луна, было особенно ценным для предотвращения ошибок при вводе номеров карт. Кроме того, я овладел базовыми концепциями объектно-ориентированного программирования, такими как работа с классами.

Работая над проектом, я столкнулся с несколькими трудностями. Настройка и подключение к базе данных потребовали определенных усилий, но я смог преодолеть их, изучив документацию и обратившись за рекомендациями к онлайн-ресурсам. Проектирование системы для обработки различных банковских операций и обеспечения безопасности данных также создавало проблемы, но тщательное планирование и исследования помогли мне преодолеть эти препятствия.

В целом, этот проект дал мне практическое представление о банковских системах и позволил развить свои навыки работы с базами данных, SQL и объектно-ориентированным программированием. Это был ценный учебный опыт, который расширил мои знания и способности к решению проблем.
2. Follow the on-screen instructions: The program will display a menu with different options. Enter the corresponding number to perform the desired action.
3. 
## Feedback
During this project, I learned about the functioning of a banking system and gained knowledge about SQL and databases. Understanding how the Luhn algorithm works was particularly valuable in preventing errors when entering card numbers. Additionally, I grasped basic object-oriented programming concepts, such as working with classes.

While working on the project, I encountered a few difficulties. Setting up and connecting to the database required some effort, but I was able to overcome it by studying the documentation and seeking guidance from online resources. Designing the system to handle various banking operations and ensuring data security also posed challenges, but careful planning and research helped me overcome these obstacles.

Overall, this project provided me with a practical understanding of banking systems and allowed me to develop my skills in working with databases, SQL, and object-oriented programming. It was a valuable learning experience that enhanced my knowledge and problem-solving abilities.

## Contributing
Contributions to the Simple Banking System project are welcome. If you would like to contribute, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your modifications.
4. Test your changes to ensure they work as intended.
5. Commit your changes and push them to your forked repository.
6. Submit a pull request, describing the changes you made and their purpose.

## Dependencies
The Simple Banking System project has the following dependencies:

1. Java Development Kit (JDK): Ensure that you have a compatible JDK installed. Make sure you have JDK version 17.0 or higher installed. You can download the latest JDK from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/#java17).
2. SQLite JDBC Driver: Obtain the driver from a reliable source and include it in the project's classpath. The recommended version is 3.41.2. You can download the JDBC driver from the [SQLite JDBC Driver website](https://github.com/xerial/sqlite-jdbc/releases) or include it as a Maven/Gradle dependency.

## Contact Information
If you have any questions or concerns regarding the Simple Banking System project, please contact the project maintainer:
- Name: ```Serik Makzhanov```
- Email: ```serik.makzhanov@gmail.com```
## Способствующий
Приветствуются взносы в проект "Простая банковская система". Если вы хотите внести свой вклад, пожалуйста, следуйте этим рекомендациям:

1. Создайте новую ветвь репозитория.
2. Создайте новую ветку для вашей функции или исправления ошибки.
3. Внесите свои изменения.
4. Протестируйте свои изменения, чтобы убедиться, что они работают так, как задумано.
5. Зафиксируйте свои изменения и отправьте их в свой разветвленный репозиторий.
6. Отправьте запрос на удаление, описав внесенные вами изменения и их цель.

## Зависимости
Проект Simple Banking System имеет следующие зависимости:

1. Java Development Kit (JDK): Убедитесь, что у вас установлен совместимый JDK. Убедитесь, что у вас установлен JDK версии 17.0 или выше. Вы можете загрузить последнюю версию JDK с [официального веб-сайта Oracle](https://www.oracle.com/java/technologies/downloads/#java17 ).
2. Драйвер SQLite JDBC: получите драйвер из надежного источника и включите его в путь к классам проекта. Рекомендуемая версия - 3.41.2. Вы можете загрузить драйвер JDBC с [веб-сайта драйвера SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases ) или включите его в качестве зависимости Maven / Gradle.

## Контактная информация
Если у вас есть какие-либо вопросы или опасения относительно проекта Simple Banking System, пожалуйста, свяжитесь с сопровождающим проекта:
- Имя: `Серик Макжанов``
- Электронная почта: ``serik.makzhanov@gmail.com ``
