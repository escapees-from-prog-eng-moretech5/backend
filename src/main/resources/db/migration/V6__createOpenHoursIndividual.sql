CREATE TABLE IF NOT EXISTS office_open_hours_individual (
    id UUID NOT NULL,
    office_id UUID NOT NULL,
    day SMALLINT NOT NULL,
    open SMALLINT,
    close SMALLINT,

    CONSTRAINT office_open_hours_individual_pk FOREIGN KEY (office_id) REFERENCES offices(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
)