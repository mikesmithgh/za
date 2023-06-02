-- users
insert into za.users (email)
values ('mike@fakeemail.com');
insert into za.users (email)
values ('bob@fakeemail.com');
insert into za.users (email)
values ('john@fakeemail.com');
insert into za.users (email)
values ('jane@fakeemail.com');
insert into za.users (email)
values ('maria@fakeemail.com');

-- toppings
insert into za.toppings (name)
values ('pepperoni');
insert into za.toppings (name)
values ('sausage');
insert into za.toppings (name)
values ('pineapple');
insert into za.toppings (name)
values ('mushroom');
insert into za.toppings (name)
values ('ham');
insert into za.toppings (name)
values ('green peppers');
insert into za.toppings (name)
values ('onions');
insert into za.toppings (name)
values ('extra cheese');
insert into za.toppings (name)
values ('black olives');

-- user toppings
insert into za.user_topping (user_id, topping_id)
values (1, 1);
insert into za.user_topping (user_id, topping_id)
values (2, 3);
insert into za.user_topping (user_id, topping_id)
values (2, 5);
insert into za.user_topping (user_id, topping_id)
values (3, 1);
insert into za.user_topping (user_id, topping_id)
values (3, 2);
insert into za.user_topping (user_id, topping_id)
values (4, 1);
insert into za.user_topping (user_id, topping_id)
values (4, 2);
insert into za.user_topping (user_id, topping_id)
values (4, 3);
insert into za.user_topping (user_id, topping_id)
values (4, 4);
insert into za.user_topping (user_id, topping_id)
values (4, 5);
insert into za.user_topping (user_id, topping_id)
values (4, 6);
insert into za.user_topping (user_id, topping_id)
values (4, 7);
insert into za.user_topping (user_id, topping_id)
values (4, 8);
