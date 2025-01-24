-- CREATE TABLE public.Roles (
--   id BIGSERIAL PRIMARY KEY,
--   roles VARCHAR(50) UNIQUE NOT NULL
-- );

-- CREATE TABLE public.user_roles(
--   user_id BIGINT NOT NULL,
--   roles_id BIGINT NOT NULL,
--   PRIMARY KEY (user_id, roles_id),
--   FOREIGN KEY (user_id) REFERENCES public.user(id) ON DELETE CASCADE,
--   FOREIGN KEY (roles_id) REFERENCES public.roles(id) ON DELETE CASCADE
-- )

-- ALTER TABLE public.token ADD COLUMN deviceInfo VARCHAR(100);


INSERT INTO public.roles (id, roles) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_MANAGER'),
(4, 'ROLE_SUPERVISOR'),
(5, 'ROLE_GUEST');

INSERT INTO public.user_roles (user_id, roles_id) VALUES
(1, 1), (1, 2),
(2, 1), (2, 3),
(3, 1), (3, 4),
(4, 1), (4, 5),
(5, 1), (5, 2), (5, 3),
(6, 1), (6, 4), (6, 5),
(7, 1), (7, 2), (7, 3), (7, 4),
(8, 1), (8, 5),
(9, 1), (9, 2), (9, 3),
(10, 1), (10, 4), (10, 5);
