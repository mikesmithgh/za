-- case insensitive text
create extension if not exists citext with schema za;

create table za.users (
  id bigserial constraint users_pk primary key,
  email citext not null constraint users_pk2 unique
);

create table za.toppings (
  id bigserial constraint toppings_pk primary key,
  name citext not null constraint toppings_pk2 unique
);

create table za.user_topping (
  user_id bigint not null constraint user_topping_users_id_fk references za.users,
  topping_id bigint not null constraint user_topping_toppings_id_fk references za.toppings,
  constraint user_topping_pk primary key (topping_id, user_id)
);

create view za.user_count_by_topping(count, name) as
select
  count(u.email) as count,
  t.name
from
  user_topping ut
    join users u on ut.user_id = u.id
    right join toppings t on t.id = ut.topping_id
group by
  t.name;

alter table za.users owner to postgres;
alter table za.toppings owner to postgres;
alter table za.user_topping owner to postgres;
alter table za.user_count_by_topping owner to postgres;
