package su.egorovwa.model;

/**
 * Статус закрытия заказа
 * NORMAL - стандартное закрытие заказа
 * DRIVER_CANCELED - водитель отменил
 * PASSENGER_CANCELED - пассажир отменил
 * TIME_OUT - время принятия заказа вышло заказ не принят ни одним водителем
 */
public enum OrderCloseStatus {
    NORMAL,
    DRIVER_CANCELED,
    PASSENGER_CANCELED,
    TIME_OUT
}
