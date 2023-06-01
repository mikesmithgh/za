-- case insensitive text
create extension if not exists citext with schema za;

create table za.users (
  id serial constraint users_pk primary key,
  email citext not null constraint users_pk2 unique
);

create table za.toppings (
  id serial constraint toppings_pk primary key,
  name citext not null constraint toppings_pk2 unique
);

create table za.user_topping (
  user_id int not null constraint user_topping_users_id_fk references za.users,
  topping_id int not null constraint user_topping_toppings_id_fk references za.toppings,
  constraint user_topping_pk primary key (topping_id, user_id)
);

create view za.user_count_by_topping(topping, count) as
select
  t.name,
  count(u.email) as count
from
  user_topping ut
    join users u on ut.user_id = u.id
    right join toppings t on t.id = ut.topping_id
group by t.name
order by count desc;

alter table za.users owner to postgres;
alter table za.toppings owner to postgres;
alter table za.user_topping owner to postgres;
alter table za.user_count_by_topping owner to postgres;
