CREATE TABLE Msg_Text (
  ID       INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  content VARCHAR(256)                        NOT NULL,
  msg VARCHAR(256)                            NOT NULL
)DEFAULT CHARSET = utf8,ENGINE = InnoDB;