CREATE TABLE public.Token (
  id BIGSERIAL PRIMARY KEY,
  token TEXT UNIQUE NOT NULL,
  user_id BIGINT,
  FOREIGN KEY (user_id) REFERENCES public.user(id)
);