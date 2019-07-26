CREATE DATABASE reactivecomp_db;

CREATE USER reactivecomp_user WITH PASSWORD 'reactivecomp_pwd';
GRANT ALL PRIVILEGES ON DATABASE reactivecomp_db TO reactivecomp_user;

-- Connect to the database: \connect reactivecomp_db;
CREATE TABLE galaxy(id serial PRIMARY KEY, name VARCHAR(100), description VARCHAR(3000));

-- Source: https://en.wikipedia.org/wiki/List_of_galaxies
INSERT INTO galaxy(name, description) VALUES ('Andromeda Galaxy', 'Andromeda is the closest big galaxy to the Milky Way and is expected to collide with the Milky Way around 4 billion years from now. The two will eventually merge into a single new galaxy called Milkomeda.');
INSERT INTO galaxy(name, description) VALUES ('Comet Galaxy', 'The comet effect is caused by tidal stripping by its galaxy cluster, Abell 2667.');
INSERT INTO galaxy(name, description) VALUES ('Cosmos Redshift 7', 'Galaxy Cosmos Redshift 7 is reported to be the brightest of distant galaxies (z > 6) and to contain some of the earliest first stars (first generation; Population III) that produced the chemical elements needed for the later formation of planets and life as we know it.');
INSERT INTO galaxy(name, description) VALUES ('Hoag''s Object', 'It is of the subtype Hoag-type galaxy, and may in fact be a polar-ring galaxy with the ring in the plane of rotation of the central object.');
INSERT INTO galaxy(name, description) VALUES ('Large Magellanic Cloud', 'This is the fourth largest galaxy in the Local Group, and forms a pair with the SMC, and from recent research, may not be part of the Milky Way system of satellites at all.');
INSERT INTO galaxy(name, description) VALUES ('Small Magellanic Cloud', 'This forms a pair with the LMC, and from recent research, may not be part of the Milky Way system of satellites at all.');
INSERT INTO galaxy(name, description) VALUES ('Mayall''s Object', 'Also called VV 32 and Arp 148, this is a very peculiar looking object, and is likely to be not one galaxy, but two galaxies undergoing a collision. Event in images is a spindle shape and a ring shape.');
INSERT INTO galaxy(name, description) VALUES ('Milky Way', 'The galaxy containing the Sun and its Solar System, and therefore Earth.');
INSERT INTO galaxy(name, description) VALUES ('Tadpole Galaxy', 'This shape resulted from tidal interaction that drew out a long tidal tail.');
INSERT INTO galaxy(name, description) VALUES ('Triangulum Galaxy ', 'Being a diffuse object, its visibility is strongly affected by even small amounts of light pollution, ranging from easily visible in direct vision in truly dark skies to a difficult averted vision object in rural/suburban skies');
