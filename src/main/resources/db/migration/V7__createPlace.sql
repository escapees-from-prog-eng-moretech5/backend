CREATE TABLE IF NOT EXISTS places (
    id UUID NOT NULL,
    ip VARCHAR(32) NOT NULL,

--    CONSTRAINT UNIQUE (id, type),
    PRIMARY KEY(id)
)