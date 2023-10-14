CREATE TABLE IF NOT EXISTS atms_data (
    time TIMESTAMP NOT NULL,
    atmId UUID NOT NULL REFERENCES atms(id),
    people INTEGER NOT NULL,

    PRIMARY KEY (time, atmId)
);

CREATE TABLE IF NOT EXISTS offices_data (
     time TIMESTAMP NOT NULL,
     officeId UUID NOT NULL REFERENCES offices(id),
     people INTEGER NOT NULL,

     PRIMARY KEY (time, officeId)
);