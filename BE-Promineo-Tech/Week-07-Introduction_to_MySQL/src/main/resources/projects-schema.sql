DROP TABLE if exists projects.material;
DROP TABLE if exists projects.step;
DROP TABLE if exists projects.project_category;
DROP TABLE if exists projects.category;
DROP TABLE if exists projects.project;

CREATE TABLE project (
  project_id int NOT NULL AUTO_INCREMENT,
  project_name varchar(128) NOT NULL,
  estimated_hours decimal(7,2) DEFAULT NULL,
  actual_hours decimal(7,2) DEFAULT NULL,
  difficulty int DEFAULT NULL,
  notes text,
  PRIMARY KEY (project_id),
  UNIQUE KEY project_id_UNIQUE (project_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE material (
  material_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  material_name varchar(128) NOT NULL,
  num_required int DEFAULT NULL,
  cost decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (material_id),
  UNIQUE KEY material_id_UNIQUE (material_id),
  CONSTRAINT FK_ProjectMaterial FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE step (
  step_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  step_text text NOT NULL,
  step_order int NOT NULL,
  PRIMARY KEY (step_id),
  UNIQUE KEY step_id_UNIQUE (step_id),
  CONSTRAINT FK_ProjectStep FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE category (
  category_id int NOT NULL AUTO_INCREMENT,
  category_name varchar(128) NOT NULL,
  PRIMARY KEY (category_id),
  UNIQUE KEY category_id_UNIQUE (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE project_category (
  project_category_id int NOT NULL AUTO_INCREMENT,
  project_id int NOT NULL,
  category_id int NOT NULL,
  PRIMARY KEY (project_category_id),
  UNIQUE KEY project_category_UNIQUE (project_id, category_id),
  CONSTRAINT FK_ProjectCategory FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE cascade,
  CONSTRAINT FK_CategoryProject FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
    
      