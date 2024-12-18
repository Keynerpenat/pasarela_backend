CREATE TABLE pagos (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    monto DOUBLE PRECISION,
    pago_completo BOOLEAN,
    fecha_pago TIMESTAMP,
    estado_pago VARCHAR(50)
);
