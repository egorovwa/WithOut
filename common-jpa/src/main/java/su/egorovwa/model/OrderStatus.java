package su.egorovwa.model;

/**
 * Статус зказа
 * CREATED - заказ поступил от пасика
 * WAIT_DRIVER - заказ добавлен в список заказов
 * DRIVERS_FOUND - есть запросы от водителей
 * DRIVER_SELECTED - аодитель выбран
 * DRIVER_CONFIRMED - водитель подтвердил начало выполнеия
 * PASSENGER_NOTIFIED - пассажир проинформирован о водителе
 * DRIVER_IN_ADRESS - водитель на месте
 * IN_PROGRESS - водител начал выполнять заказ
 * CLOSED - заказ завершен
 */
public enum OrderStatus {

    CREATED,
    WAIT_DRIVER,
    DRIVER_REQUESTS,
    DRIVERS_FOUND,
    DRIVER_SELECTED,
    DRIVER_CONFIRMED,
    PASSENGER_NOTIFIED,
    DRIVER_IN_ADRESS,
    IN_PROGRESS,
    CLOSED

}
