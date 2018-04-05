DELETE FROM user;
INSERT INTO user(ID, USERNAME, NAME, PASSWORD, EMAIL, STREETADDRESS, CITY, COUNTRY) VALUES
  (1, 'hellofriends', 'John', 'bigman', 'johnnyjohn@jesus.maria', 'Rua dos paus 1', 'Paugrande', 'Paumaior'),
  (2, 'nabo123', 'Jose', 'asdf', 'jesus@jesus.maria', 'Rua das meias 2', 'Bagdad', 'Iraq'),
  (3, 'loser', 'Bigest', 'fuck', 'loser@jesus.maria', 'Rua dos bananas 3', 'Portalegre', 'Portugal'),
  (4, '1234', 'Maria', 'qwerty', 'maria@jesus.maria', 'Rua das batatas 1', 'Sao Paulo', 'Brasil'),
  (5, 'richard', 'Richard', 'virgin', 'richard@jesus.maria', 'Rua dos lilases', 'Almada', 'Portugal');

DELETE FROM item;
INSERT INTO item(ID, NAME, description) VALUES
  (1, 'Batata', 'As batatas mais bouas do norte'),
  (2, 'Benuron', 'Supositorios'),
  (3, 'Agua', 'Agua potavel'),
  (4, 'Dolars', 'Dinheiro'),
  (5, 'Carne', 'A melhor carne de vaca de Ermesinde');

DELETE FROM offer;
INSERT INTO offer(ID, user_id_id, item_id_id, amount, date) VALUES
  (1, 1, 1, 100, '2018_04_02'),
  (2, 2, 2, 15, '2018_04_01'),
  (3, 2, 3, 30, '2018_03_29'),
  (4, 2, 4, 10, '2018_04_01'),
  (5, 3, 2, 10, '2018_04_04');

DELETE FROM demand;
INSERT INTO demand(ID, user_id_id, item_id_id, amount, date) VALUES
  (1, 4, 1, 80, '2018_04_02'),
  (2, 4, 2, 10, '2018_04_01'),
  (3, 5, 3, 15, '2018_03_29'),
  (4, 5, 4, 20, '2018_04_01'),
  (5, 5, 2, 30, '2018_04_04');
