-- case insensitive text
create extension if not exists citext with schema za;


create table za.users
(
    id    serial
        constraint users_pk primary key,
    email citext not null
        constraint users_pk2 unique
);


create table za.toppings
(
    id   serial
        constraint toppings_pk primary key,
    name citext not null
        constraint toppings_pk2 unique
);


create table za.user_topping
(
    user_id    int not null
        constraint user_topping_users_id_fk references za.users,
    topping_id int not null
        constraint user_topping_toppings_id_fk references za.toppings,
    constraint user_topping_pk primary key (topping_id,
                                            user_id)
);


create view za.user_count_by_topping(topping, count) as
select t.name,
       count(u.email) as count
from user_topping ut
         join users u on ut.user_id = u.id
         right join toppings t on t.id = ut.topping_id
group by t.name
order by count desc;


create or replace function za.add_user_toppings(local_user_email text, local_user_toppings_str text)
    returns table
            (
                user_id      integer,
                user_email   citext,
                topping_id   integer,
                topping_name citext
            )
as
$$
declare
    local_user_id           integer;
    local_user_toppings_arr text;
begin
    local_user_toppings_arr = string_to_array(local_user_toppings_str, ',');
    -- create user if it does not exist
    insert into za.users (email) values (local_user_email) on conflict do nothing;
    select id into local_user_id from za.users where email = local_user_email limit 1;
    -- create toppings if they do not exist
    insert into za.toppings (name) select unnest(local_user_toppings_arr::text[]) on conflict do nothing;
    -- delete all previous user toppings for the user
    delete from za.user_topping ut where ut.user_id = local_user_id;
    -- insert new toppings for the user into user toppings
    insert into za.user_topping (user_id, topping_id)
    select local_user_id, t.id
    from za.toppings t
    where name = any (local_user_toppings_arr::text[]);

    return query
        with cte as (select id, email
                     from za.users
                     where id = local_user_id)
        select u.id, u.email, t.id, t.name
        from za.toppings t,
             cte u
        where t.name = any (local_user_toppings_arr::text[]);

end;
$$ language plpgsql;


alter table za.users
    owner to postgres;


alter table za.toppings
    owner to postgres;


alter table za.user_topping
    owner to postgres;


alter table za.user_count_by_topping
    owner to postgres;


alter function za.add_user_toppings(text, text) owner to postgres;