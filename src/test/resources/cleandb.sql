use test_cookbook;
delete from instruction;
delete from ingredient;
delete from recipe;
delete from category;
delete from role;
delete from user;
INSERT INTO `user` VALUES (1, 'Joanne', 'Saunders', 'joanne.saunders@hansonmanor.us', 'secret123$'),
  (2, 'Rose', 'Saunders', 'rose.saunders@hansonmanor.us', 'secret123$'),
  (4, 'Phyllis', 'Diller', 'someone@nothing.us', 'secret123$'),
  (5, 'Betty', 'Boop', 'anotherOne@nothing.com', 'secret123$'),
  (6, 'Arnold', 'Palmer', 'golfer@golfers.com', 'secret123$'),
  (7, 'Fred', 'Flintstone', 'fflintstone', 'secret123$'),
  (9, 'Amber', 'Saunders', 'amber@hansonmanor.us', NULL);
INSERT INTO `role` VALUES (1,'administrator','joanne.saunders@hansonmanor.us',1),(2,'general','joanne.saunders@hansonmanor.us',1),(3,'general','rose.saunders@hansonmanor.us',2),(4,'general','amber@hansonmanor.us',9);
INSERT INTO `category` VALUES (3,'Salad',1),(4,'Soup',1),(5,'Bread',1),(6,'Candy',1),(7,'Eggs',1);
INSERT INTO `recipe` VALUES (1,'Fudge',1,0,NULL,'1 oz',16),(2,'Scrambled Eggs',1,1,NULL,'2 eggs',1);
INSERT INTO `ingredient` VALUES (1,'Egg(s)',2,'2',NULL),(2,'Milk',2,'2',3),(3,'Sugar',1,'3',1),(4,'Baking Cocoa',1,'1/3',1);
INSERT INTO `instruction` VALUES (1,'Combine Milk and Eggs in a bowl',2),(2,'Combine Sugar and Water in heavy sauce pan.',1);
