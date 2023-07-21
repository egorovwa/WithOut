CREATE TABLE car
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    mark_id  BIGINT,
    model_id BIGINT,
    year     INTEGER,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE car_mark
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_carmark PRIMARY KEY (id)
);

CREATE TABLE car_mark_models
(
    car_mark_id BIGINT NOT NULL,
    models_id   BIGINT NOT NULL
);

CREATE TABLE car_model
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_carmodel PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    phone          VARCHAR(255),
    fist_name      VARCHAR(255),
    last_name      VARCHAR(255),
    password       VARCHAR(255),
    email          VARCHAR(255),
    registred_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    current_cat_id BIGINT,
    is_avalible    BOOLEAN,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE driver_cars
(
    driver_id BIGINT NOT NULL,
    cars_id   BIGINT NOT NULL
);

ALTER TABLE car_mark_models
    ADD CONSTRAINT uc_car_mark_models_models UNIQUE (models_id);

ALTER TABLE driver_cars
    ADD CONSTRAINT uc_driver_cars_cars UNIQUE (cars_id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_MARK FOREIGN KEY (mark_id) REFERENCES car_mark (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_MODEL FOREIGN KEY (model_id) REFERENCES car_model (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_CURRENTCAT FOREIGN KEY (current_cat_id) REFERENCES car (id);

ALTER TABLE car_mark_models
    ADD CONSTRAINT fk_carmarmod_on_car_mark FOREIGN KEY (car_mark_id) REFERENCES car_mark (id);

ALTER TABLE car_mark_models
    ADD CONSTRAINT fk_carmarmod_on_car_model FOREIGN KEY (models_id) REFERENCES car_model (id);

ALTER TABLE driver_cars
    ADD CONSTRAINT fk_dricar_on_car FOREIGN KEY (cars_id) REFERENCES car (id);

ALTER TABLE driver_cars
    ADD CONSTRAINT fk_dricar_on_driver FOREIGN KEY (driver_id) REFERENCES driver (id);