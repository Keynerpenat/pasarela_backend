CREATE TABLE honestidad (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    pago_inmediato BOOLEAN,
    fecha_pago TIMESTAMP,
    monto DOUBLE PRECISION
);
