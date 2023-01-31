DROP TABLE if exists projects.material;
DROP TABLE if exists projects.step;
DROP TABLE if exists projects.project_category;
DROP TABLE if exists projects.category;
DROP TABLE if exists projects.project;

CREATE TABLE projects.project (
  project_id int NOT NULL AUTO_INCREMENT,
  project_name varchar(128) NOT NULL,
  estimated_hours decimal(7,2) DEFAULT NULL,
  actual_hours decimal(7,2) DEFAULT NULL,
  difficulty int DEFAULT NULL,
  notes text,
  PRIMARY KEY (project_id),
  UNIQUE KEY project_id_UNIQUE (project_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE projects.material (
  material_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  material_name varchar(128) NOT NULL,
  num_required int DEFAULT NULL,
  cost decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (material_id),
  UNIQUE KEY material_id_UNIQUE (material_id),
  CONSTRAINT FK_ProjectMaterial FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE projects.step (
  step_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  step_text text NOT NULL,
  step_order int NOT NULL,
  PRIMARY KEY (step_id),
  UNIQUE KEY step_id_UNIQUE (step_id),
  CONSTRAINT FK_ProjectStep FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE projects.category (
  category_id int NOT NULL AUTO_INCREMENT,
  category_name varchar(128) NOT NULL,
  PRIMARY KEY (category_id),
  UNIQUE KEY category_id_UNIQUE (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE projects.project_category (
  project_category_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  category_id int NOT NULL,
  PRIMARY KEY (project_category_id),
  UNIQUE KEY project_category_UNIQUE (project_id, category_id),
  CONSTRAINT FK_ProjectCategory FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE cascade,
  CONSTRAINT FK_CategoryProject FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
    
INSERT INTO projects.project (project_name, estimated_hours, actual_hours, difficulty, notes) VALUES ('Install backsplash', 52, 69, 5, 'Watch youtube for ideas');
INSERT INTO projects.category (category_name) VALUES ('Kitchen');
INSERT INTO projects.material (project_id, material_name, num_required) values ((select project_id from project where project_name = 'Install backsplash'), 'Tile', 56);
INSERT INTO projects.material (project_id, material_name, num_required) values ((select project_id from project where project_name = 'Install backsplash'), 'Backing', 5);
INSERT INTO projects.material (project_id, material_name, num_required) values ((select project_id from project where project_name = 'Install backsplash'), 'Grout', 1);
INSERT INTO projects.material (project_id, material_name, num_required) values ((select project_id from project where project_name = 'Install backsplash'), 'Spacers', 100);
INSERT INTO projects.step (project_id, step_text, step_order) values ((select project_id from project where project_name = 'Install backsplash'), 'Remove existing backing, nails and sheetrock', 1);
INSERT INTO projects.step (project_id, step_text, step_order) values ((select project_id from project where project_name = 'Install backsplash'), 'Purchase materials', 2);
INSERT INTO projects.step (project_id, step_text, step_order) values ((select project_id from project where project_name = 'Install backsplash'), 'Install backing', 3);
INSERT INTO projects.step (project_id, step_text, step_order) values ((select project_id from project where project_name = 'Install backsplash'), 'Install tile', 4);
INSERT INTO projects.step (project_id, step_text, step_order) values ((select project_id from project where project_name = 'Install backsplash'), 'Apply grout', 5);
INSERT INTO projects.project_category (project_id, category_id) values ((select project_id from project where project_name = 'Install backsplash'), (select category_id from category where category_name = 'Kitchen') );
commit;

      