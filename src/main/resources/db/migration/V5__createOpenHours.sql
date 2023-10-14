CREATE TABLE IF NOT EXISTS office_open_hours (
    office_id UUID NOT NULL,
    day SMALLINT NOT NULL,
    open SMALLINT,
    close SMALLINT,

    CONSTRAINT office_open_hours_pk FOREIGN KEY (office_id) REFERENCES offices(id) ON DELETE CASCADE,
    PRIMARY KEY (office_id, day)
)