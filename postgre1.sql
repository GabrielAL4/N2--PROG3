--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2022-12-15 15:48:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 24610)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    matricula character varying(255),
    codigo bigint NOT NULL
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24616)
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    id bigint NOT NULL,
    nacionalidade character varying(255),
    nome character varying(255),
    sobrenome character varying(255)
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24615)
-- Name: autor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autor_id_seq OWNER TO postgres;

--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 215
-- Name: autor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autor_id_seq OWNED BY public.autor.id;


--
-- TOC entry 217 (class 1259 OID 24624)
-- Name: autor_livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor_livro (
    autor_id bigint NOT NULL,
    livros_id bigint NOT NULL
);


ALTER TABLE public.autor_livro OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24628)
-- Name: emprestimo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprestimo (
    id bigint NOT NULL,
    datadevolucao date,
    dataemprestimo date,
    dataprevistadevolucao date,
    exemplar_codigo bigint,
    leitor_codigo bigint
);


ALTER TABLE public.emprestimo OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24627)
-- Name: emprestimo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprestimo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.emprestimo_id_seq OWNER TO postgres;

--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 218
-- Name: emprestimo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprestimo_id_seq OWNED BY public.emprestimo.id;


--
-- TOC entry 221 (class 1259 OID 24635)
-- Name: exemplar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exemplar (
    codigo bigint NOT NULL,
    dataaquisicao date,
    disponivel boolean NOT NULL,
    titulo character varying(255),
    livro_id bigint
);


ALTER TABLE public.exemplar OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24634)
-- Name: exemplar_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exemplar_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exemplar_codigo_seq OWNER TO postgres;

--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 220
-- Name: exemplar_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exemplar_codigo_seq OWNED BY public.exemplar.codigo;


--
-- TOC entry 223 (class 1259 OID 24642)
-- Name: leitor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leitor (
    codigo bigint NOT NULL,
    endereco character varying(255),
    nome character varying(255),
    prazomaximodedevolucao integer,
    telefone character varying(255)
);


ALTER TABLE public.leitor OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24641)
-- Name: leitor_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leitor_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.leitor_codigo_seq OWNER TO postgres;

--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 222
-- Name: leitor_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leitor_codigo_seq OWNED BY public.leitor.codigo;


--
-- TOC entry 225 (class 1259 OID 24651)
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    id bigint NOT NULL,
    titulo character varying(255),
    autor_id bigint
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 24650)
-- Name: livro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_id_seq OWNER TO postgres;

--
-- TOC entry 3399 (class 0 OID 0)
-- Dependencies: 224
-- Name: livro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_id_seq OWNED BY public.livro.id;


--
-- TOC entry 226 (class 1259 OID 24657)
-- Name: professor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.professor (
    disciplina character varying(255),
    codigo bigint NOT NULL
);


ALTER TABLE public.professor OWNER TO postgres;

--
-- TOC entry 3205 (class 2604 OID 24619)
-- Name: autor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor ALTER COLUMN id SET DEFAULT nextval('public.autor_id_seq'::regclass);


--
-- TOC entry 3206 (class 2604 OID 24631)
-- Name: emprestimo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo ALTER COLUMN id SET DEFAULT nextval('public.emprestimo_id_seq'::regclass);


--
-- TOC entry 3207 (class 2604 OID 24638)
-- Name: exemplar codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplar ALTER COLUMN codigo SET DEFAULT nextval('public.exemplar_codigo_seq'::regclass);


--
-- TOC entry 3208 (class 2604 OID 24645)
-- Name: leitor codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leitor ALTER COLUMN codigo SET DEFAULT nextval('public.leitor_codigo_seq'::regclass);


--
-- TOC entry 3209 (class 2604 OID 24654)
-- Name: livro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro ALTER COLUMN id SET DEFAULT nextval('public.livro_id_seq'::regclass);


--
-- TOC entry 3376 (class 0 OID 24610)
-- Dependencies: 214
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (matricula, codigo) FROM stdin;
1321312	1
\.


--
-- TOC entry 3378 (class 0 OID 24616)
-- Dependencies: 216
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor (id, nacionalidade, nome, sobrenome) FROM stdin;
1	Brasileiro	Machado 	De Assis
\.


--
-- TOC entry 3379 (class 0 OID 24624)
-- Dependencies: 217
-- Data for Name: autor_livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor_livro (autor_id, livros_id) FROM stdin;
\.


--
-- TOC entry 3381 (class 0 OID 24628)
-- Dependencies: 219
-- Data for Name: emprestimo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.emprestimo (id, datadevolucao, dataemprestimo, dataprevistadevolucao, exemplar_codigo, leitor_codigo) FROM stdin;
1	\N	2022-12-15	2022-12-30	1	1
\.


--
-- TOC entry 3383 (class 0 OID 24635)
-- Dependencies: 221
-- Data for Name: exemplar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exemplar (codigo, dataaquisicao, disponivel, titulo, livro_id) FROM stdin;
1	2022-12-15	f	\N	1
\.


--
-- TOC entry 3385 (class 0 OID 24642)
-- Dependencies: 223
-- Data for Name: leitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leitor (codigo, endereco, nome, prazomaximodedevolucao, telefone) FROM stdin;
1	Rua 1	Gabriel	15	2311312
2	Rua 1	Eduardo	30	\N
\.


--
-- TOC entry 3387 (class 0 OID 24651)
-- Dependencies: 225
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.livro (id, titulo, autor_id) FROM stdin;
1	Dom casmurro	1
\.


--
-- TOC entry 3388 (class 0 OID 24657)
-- Dependencies: 226
-- Data for Name: professor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.professor (disciplina, codigo) FROM stdin;
txtDisciplina	2
\.


--
-- TOC entry 3400 (class 0 OID 0)
-- Dependencies: 215
-- Name: autor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autor_id_seq', 1, true);


--
-- TOC entry 3401 (class 0 OID 0)
-- Dependencies: 218
-- Name: emprestimo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprestimo_id_seq', 1, true);


--
-- TOC entry 3402 (class 0 OID 0)
-- Dependencies: 220
-- Name: exemplar_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exemplar_codigo_seq', 1, true);


--
-- TOC entry 3403 (class 0 OID 0)
-- Dependencies: 222
-- Name: leitor_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leitor_codigo_seq', 2, true);


--
-- TOC entry 3404 (class 0 OID 0)
-- Dependencies: 224
-- Name: livro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_id_seq', 1, true);


--
-- TOC entry 3211 (class 2606 OID 24614)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3213 (class 2606 OID 24623)
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);


--
-- TOC entry 3217 (class 2606 OID 24633)
-- Name: emprestimo emprestimo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (id);


--
-- TOC entry 3219 (class 2606 OID 24640)
-- Name: exemplar exemplar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplar
    ADD CONSTRAINT exemplar_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3221 (class 2606 OID 24649)
-- Name: leitor leitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leitor
    ADD CONSTRAINT leitor_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3223 (class 2606 OID 24656)
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id);


--
-- TOC entry 3225 (class 2606 OID 24661)
-- Name: professor professor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3215 (class 2606 OID 24663)
-- Name: autor_livro uk_sl3nfihcekhe9224arfdpmlfd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT uk_sl3nfihcekhe9224arfdpmlfd UNIQUE (livros_id);


--
-- TOC entry 3227 (class 2606 OID 24669)
-- Name: autor_livro fk3ukd9fsr2ls5rqsd3g9xh5yt4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT fk3ukd9fsr2ls5rqsd3g9xh5yt4 FOREIGN KEY (livros_id) REFERENCES public.livro(id);


--
-- TOC entry 3229 (class 2606 OID 24679)
-- Name: emprestimo fk7r6wnmo82724urdtxlsde5j5g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT fk7r6wnmo82724urdtxlsde5j5g FOREIGN KEY (exemplar_codigo) REFERENCES public.exemplar(codigo);


--
-- TOC entry 3233 (class 2606 OID 24699)
-- Name: professor fk9jmesv9ehi1d0pxd8sx14i4sf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT fk9jmesv9ehi1d0pxd8sx14i4sf FOREIGN KEY (codigo) REFERENCES public.leitor(codigo);


--
-- TOC entry 3226 (class 2606 OID 24664)
-- Name: aluno fka8q616dpclb6pdc919gh80c0t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fka8q616dpclb6pdc919gh80c0t FOREIGN KEY (codigo) REFERENCES public.leitor(codigo);


--
-- TOC entry 3232 (class 2606 OID 24694)
-- Name: livro fkbikeff7o0o2h3dciq42ykea6g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fkbikeff7o0o2h3dciq42ykea6g FOREIGN KEY (autor_id) REFERENCES public.autor(id);


--
-- TOC entry 3230 (class 2606 OID 24684)
-- Name: emprestimo fkgvkvw8j5jr5or1op50lolwxr3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT fkgvkvw8j5jr5or1op50lolwxr3 FOREIGN KEY (leitor_codigo) REFERENCES public.leitor(codigo);


--
-- TOC entry 3228 (class 2606 OID 24674)
-- Name: autor_livro fkich0yljhqsqwgemfnfqrq4fg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT fkich0yljhqsqwgemfnfqrq4fg FOREIGN KEY (autor_id) REFERENCES public.autor(id);


--
-- TOC entry 3231 (class 2606 OID 24689)
-- Name: exemplar fkp9avt8s5140kfi1wkhmbw2v0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exemplar
    ADD CONSTRAINT fkp9avt8s5140kfi1wkhmbw2v0 FOREIGN KEY (livro_id) REFERENCES public.livro(id);


-- Completed on 2022-12-15 15:48:57

--
-- PostgreSQL database dump complete
--

