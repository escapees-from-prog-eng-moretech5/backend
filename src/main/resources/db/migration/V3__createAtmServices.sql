CREATE TABLE IF NOT EXISTS atm_services (
    id UUID NOT NULL,
    atm_id UUID NOT NULL,
    service VARCHAR(32) NOT NULL,
    capability VARCHAR(12) NOT NULL,
    activity VARCHAR(12) NOT NULL,

    CONSTRAINT atm_services_pk FOREIGN KEY (atm_id) REFERENCES atms(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
)