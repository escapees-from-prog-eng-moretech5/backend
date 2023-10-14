CREATE TABLE IF NOT EXISTS offices (
    id UUID NOT NULL,
    sale_point_name VARCHAR(255) NOT NULL,
    address VARCHAR(400) NOT NULL,
    sale_point_code VARCHAR(255),
    status VARCHAR(255),
    rko BOOLEAN DEFAULT FALSE,
    network VARCHAR(255),
    office_type VARCHAR(255),
    sale_point_format VARCHAR(255),
    suo_availability BOOLEAN DEFAULT FALSE,
    has_ramp BOOLEAN DEFAULT FALSE,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    metro_station VARCHAR(500),
    distance INTEGER,
    kep BOOLEAN DEFAULT FALSE,
    my_branch BOOLEAN DEFAULT FALSE,
    camera_ip VARCHAR(32) NOT NULL,
    windows SMALLINT NOT NULL DEFAULT 1,

    PRIMARY KEY (id)

)