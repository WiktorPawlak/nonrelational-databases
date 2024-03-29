CREATE TABLE BOXES
(
    ID          UUID                        NOT NULL,
    version     BIGINT,
    created_on  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    weight      DOUBLE PRECISION            NOT NULL,
    box_type_id UUID                        NOT NULL,
    CONSTRAINT pk_boxes PRIMARY KEY (ID)
);

CREATE TABLE BUNDLE
(
    ID      UUID    NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT pk_bundle PRIMARY KEY (ID)
);

CREATE TABLE BoxType
(
    ID         UUID                        NOT NULL,
    type       VARCHAR(31),
    version    BIGINT,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    length     INTEGER                     NOT NULL,
    width      INTEGER                     NOT NULL,
    height     INTEGER                     NOT NULL,
    CONSTRAINT pk_boxtype PRIMARY KEY (ID)
);

CREATE TABLE ENVELOPE
(
    ID       UUID    NOT NULL,
    priority INTEGER NOT NULL,
    CONSTRAINT pk_envelope PRIMARY KEY (ID)
);

CREATE TABLE SHIPMENTS
(
    ID         UUID                        NOT NULL,
    version    BIGINT,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    BOX_COST   DOUBLE PRECISION            NOT NULL,
    ONGOING    BOOLEAN                     NOT NULL,
    empty      BOOLEAN                     NOT NULL,
    password   VARCHAR(255),
    CONSTRAINT pk_shipments PRIMARY KEY (ID)
);

CREATE TABLE SHIPMENTS_boxes
(
    Shipment_ID UUID NOT NULL,
    boxes_ID    UUID NOT NULL
);

ALTER TABLE SHIPMENTS_boxes
    ADD CONSTRAINT uc_shipments_boxes_boxes UNIQUE (boxes_ID);

ALTER TABLE BOXES
    ADD CONSTRAINT FK_BOXES_ON_BOX_TYPE FOREIGN KEY (box_type_id) REFERENCES BoxType (ID);

ALTER TABLE BUNDLE
    ADD CONSTRAINT FK_BUNDLE_ON_ID FOREIGN KEY (ID) REFERENCES BoxType (ID);

ALTER TABLE ENVELOPE
    ADD CONSTRAINT FK_ENVELOPE_ON_ID FOREIGN KEY (ID) REFERENCES BoxType (ID);

ALTER TABLE SHIPMENTS_boxes
    ADD CONSTRAINT fk_shibox_on_box FOREIGN KEY (boxes_ID) REFERENCES BOXES (ID);

ALTER TABLE SHIPMENTS_boxes
    ADD CONSTRAINT fk_shibox_on_shipment FOREIGN KEY (Shipment_ID) REFERENCES SHIPMENTS (ID);