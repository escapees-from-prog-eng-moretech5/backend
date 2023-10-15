CREATE TABLE IF NOT EXISTS predictions (
    id UUID NOT NULL,
    office_id UUID NOT NULL,
    time INT NOT NULL,
    day SMALLINT NOT NULL,
    wait_time float,

    PRIMARY KEY (id)
)