CREATE TABLE IF NOT EXISTS atms (
    id UUID NOT NULL,
    code VARCHAR(32),
    bnkcd VARCHAR(32),
    address VARCHAR(255) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    all_day BOOLEAN,

    PRIMARY KEY(id)
)

