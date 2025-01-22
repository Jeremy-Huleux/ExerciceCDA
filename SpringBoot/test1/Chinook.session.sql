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

ALTER TABLE public.token ADD COLUMN deviceInfo VARCHAR(100);