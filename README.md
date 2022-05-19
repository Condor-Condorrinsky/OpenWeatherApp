# OpenWeatherApp
Przykładowa aplikacja z wykorzystaniem API OpenWeather.

Umożliwia sprawdzenie podstawowej prognozy pogody dla wybranego miasta dla najbliższych 48h lub 7 dni. Należy dostarczyć własny plik plaintext z listą miast w formacie:

*nazwa_miasta, szerokość_geograficzna, długość geograficzna*

Można również użyć przykładowej listy miast zawartej w pliku *city_list*.

**Autor: Konrad Dumin**

## Instrukcja jak zbudować i uruchomić projekt
W głównym folderze projektu (root directory) należy wywołać:

*mvn clean compile assembly:single*

Powinien powstać folder *target*. Aby uruchomić program, należy wywołać:

*cd target*

*java -jar open-weather-app-1.0.0.jar [ścieżka do pliku z miastami] [hourly/daily] [nazwa miasta po angielsku]*

Powstaly plik *.jar* stanowi samodzielną aplikację. Można go skopiować i przenieść w dowolne miejsce. Będzie on działał tak długo, jak na uruchamiającym komputerze znajduje się *JRE* i system *Maven*.
