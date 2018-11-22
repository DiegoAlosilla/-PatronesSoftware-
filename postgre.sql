--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-22 00:46:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2812 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 54297)
-- Name: lineaordencompras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lineaordencompras (
    cantidad integer NOT NULL,
    ordencompras_id integer NOT NULL,
    productos_id integer NOT NULL
);


ALTER TABLE public.lineaordencompras OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 54292)
-- Name: ordencompras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordencompras (
    id integer NOT NULL,
    total double precision NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.ordencompras OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 54302)
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    nombre character varying(45) NOT NULL,
    precio double precision NOT NULL,
    stock integer NOT NULL,
    unidad integer NOT NULL,
    categorias_id integer NOT NULL,
    proveedor_id integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- TOC entry 2679 (class 2606 OID 54301)
-- Name: lineaordencompras lineaordencompras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lineaordencompras
    ADD CONSTRAINT lineaordencompras_pkey PRIMARY KEY (cantidad);


--
-- TOC entry 2677 (class 2606 OID 54296)
-- Name: ordencompras ordencompras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordencompras
    ADD CONSTRAINT ordencompras_pkey PRIMARY KEY (id);


--
-- TOC entry 2681 (class 2606 OID 54308)
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- TOC entry 2683 (class 2606 OID 54314)
-- Name: lineaordencompras ordencompras_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lineaordencompras
    ADD CONSTRAINT ordencompras_id FOREIGN KEY (ordencompras_id) REFERENCES public.ordencompras(id);


--
-- TOC entry 2682 (class 2606 OID 54309)
-- Name: lineaordencompras productos_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lineaordencompras
    ADD CONSTRAINT productos_id FOREIGN KEY (productos_id) REFERENCES public.productos(id);


-- Completed on 2018-11-22 00:46:45

--
-- PostgreSQL database dump complete
--

