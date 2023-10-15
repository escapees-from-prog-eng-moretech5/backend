# backend

Ссылка на API: https://app.swaggerhub.com/apis/LAZARKOVDMITRY/mapVTB/v1 


Также API доступна при работе сервера по адресу http://localhost:8080/swagger-ui/index.html


Пароли пользователей, а также секретный ключ для place-controller шифруются при помощи BCryptEncoding с силой 12


Мобильное приложение отправляет запросы на бек на контроллеры:
 - auth-controller (регистрация, логин) - отправляют JWT Token для следующих 3 контроллеров
 - prediction-controller (данные о расчитанном времени ожидания в отделениях банка) 
 - office-controller (данные о отделениях банка)
 - atm-controller (данные о банкоматах)


Приложение по анализу данных с камер наблюдения делает запросы через place-controller (защита - secret password):
 - /api/v1/place/register - регистрация приложения в базе данных сервера и получение информации о офисах и камерах
 - /api/v1/place - отправка данных на сервер о числе людей в офисе банка с указанием момента времени


Вспомогательное api также через place-controller (защита - secret password): 
- /api/v1/place/predictions - позволяет загрузить mock данные наблюдения на сервер (пример файла - parsed_dataset_predictions.json)
- /api/v1/place/atms - позволяет загрузить данные о банкоматах (пример файла - parsed_atm_data.json)
- /api/v1/place/offices - позволяет загрузить mock данные о отделениях банка (пример файла - parsed_office_data.json)
