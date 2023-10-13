CREATE TABLE IF NOT EXISTS users (
    id UUID NOT NULL,
    number VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) NOT NULL,
    name VARCHAR(64),
    address VARCHAR(255),
--     address_latitude DOUBLE PRECISION,
--     address_longitude DOUBLE PRECISION,

    PRIMARY KEY(id)
)