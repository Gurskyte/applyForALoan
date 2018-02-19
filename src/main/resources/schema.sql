CREATE TABLE ACCOUNT(
    personal_number BIGINT not NULL,
    name VARCHAR(255),
    last_name VARCHAR(255),
    PRIMARY KEY(personal_number)
);

CREATE TABLE LOAN(
    id LONG not NULL AUTO_INCREMENT,
    loan_amount DECIMAL,
    months INTEGER,
    ip VARCHAR,
    issue_date TIMESTAMP,
    acc_personal_number BIGINT,
    PRIMARY KEY(id),
    FOREIGN KEY (acc_personal_number) REFERENCES ACCOUNT(personal_number)
);