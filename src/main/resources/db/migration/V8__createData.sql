CREATE TABLE IF NOT EXISTS atms_data (
    id UUID NOT NULL,
    time TIMESTAMP NOT NULL,
    atm_id UUID NOT NULL REFERENCES atms(id),
    people INTEGER NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS offices_data (
    id UUID NOT NULL,
    time INT NOT NULL,
    day SMALLINT CHECK (day between 0 and 6),
    office_id UUID NOT NULL REFERENCES offices(id),
    people INTEGER NOT NULL,

    PRIMARY KEY (id)
);