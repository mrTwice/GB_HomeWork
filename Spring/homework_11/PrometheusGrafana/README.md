# Запуск контейнеров Docker c Prometheus и Grafana

* В связи с тем, что Prometheus и Grafana развернуты в контейнерах, а все остальные сервесы не контейнеризирвоаны, возникает проблема с доступом к метрикам.
* Для решения этой проблемы в docker-compose.yml в части настроек Prometheus добавлен параметр [extra_hosts](https://github.com/mrTwice/GB_HomeWork/blob/main/Spring/homework_11/PrometheusGrafana/docker-compose.yml)
* Это позволяет приложению из контейнера получить доступ к loopback интерфейсу хостовой машины
* Из-за настроек Security в WebClient, Prometheus нужно передать [учетные данные](https://github.com/mrTwice/GB_HomeWork/blob/main/Spring/homework_11/PrometheusGrafana/config/prometheus-config.yml) для доступа к метрикам приложения. Или сделать их незащищенными.

Для проверки работоспособности проекта в части функционирования Prometheus и Grafana предполагается запуск всех [сервисов проекта](https://github.com/mrTwice/GB_HomeWork/tree/main/Spring/homework_11)