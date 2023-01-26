package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import projects.entity.Category;
import projects.entity.Material;
import projects.entity.Project;
import projects.entity.Step;
import projects.exception.DbException;
import provided.util.DaoBase;

public class ProjectDao extends DaoBase {

	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY = "project_category";
	private static final String STEP_TABLE = "step";
	
	
	public Project insertProject(Project project) {

		// @formatter:off
		String insertSQL = ""
				+ "INSERT INTO " + PROJECT_TABLE + " "
				+ "(project_name, estimated_hours, actual_hours, difficulty, notes) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?)";
		// @formatter:on
		
		try (Connection con = DbConnection.getConnection()) {
			
			startTransaction(con);
			try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
				
				setParameter(stmt,1,project.getProjectName(), String.class);
				setParameter(stmt,2,project.getEstimatedHours(), BigDecimal.class);
				setParameter(stmt,3,project.getActualHours(), BigDecimal.class);
				setParameter(stmt,4,project.getDifficulty(), Integer.class);
				setParameter(stmt,5,project.getNotes(), String.class);
				
				stmt.executeUpdate();
				Integer projectid = getLastInsertId(con, PROJECT_TABLE);
				commitTransaction(con);
				project.setProjectId(projectid);
				return project;
				
			} catch (Exception e) {
				rollbackTransaction(con);
				throw new DbException(e);
			}
			
		} catch(SQLException e) {
			throw new DbException(e);
		}
		
	}


	public List<Project> fetchAllProjects() {
		// @formatter:off
		String selectSQL = ""
				+ "SELECT PROJECT_ID, PROJECT_NAME, ESTIMATED_HOURS, ACTUAL_HOURS, DIFFICULTY, NOTES " 
				+ "FROM " + PROJECT_TABLE + " "
				+ "ORDER BY PROJECT_NAME ASC";
				// @formatter:on
		try (Connection con = DbConnection.getConnection()) {
			
			startTransaction(con);
			try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
				try (ResultSet rs = stmt.executeQuery()){
					List<Project> projects = new LinkedList<>();
					while (rs.next()) {
						projects.add(extract(rs, Project.class));
					}
					commitTransaction(con);
					return projects;
										
				} catch (Exception e) {
					rollbackTransaction(con);
					throw new DbException(e);
				}
				
			} catch (Exception e) {
				throw new DbException(e);
			}
			
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}


	public Optional<Project> fetchProjectById(int projectId) {
		// @formatter:off
		String selectSQL = ""
				+ "SELECT PROJECT_ID, PROJECT_NAME, ESTIMATED_HOURS, ACTUAL_HOURS, DIFFICULTY, NOTES " 
				+ "FROM " + PROJECT_TABLE + " "
				+ "WHERE PROJECT_ID = ?";
		// @formatter:on
		try (Connection con = DbConnection.getConnection()) {
			
			startTransaction(con);
			try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
				setParameter(stmt,1,projectId, Integer.class);
				try (ResultSet rs = stmt.executeQuery()){
					Project project = null;
					if (rs.next()) {
						project = extract(rs, Project.class);
					}
					
					if (Objects.nonNull(project)) {
						project.getMaterials().addAll(fetchMaterialsForProject(con, projectId));
						project.getSteps().addAll(fetchStepsForProject(con, projectId));
						project.getCategories().addAll(fetchCategoriesForProject(con, projectId));
					}
					
					commitTransaction(con);
					return Optional.ofNullable(project);
										
				} catch (Exception e) {
					rollbackTransaction(con);
					throw new DbException(e);
				}
				
			} catch (Exception e) {
				throw new DbException(e);
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}


	private List<Material> fetchMaterialsForProject(Connection con, Integer projectId) throws SQLException{
		// @formatter:off
				String selectSQL = ""
						+ "SELECT MAT.* " 
						+ "FROM " + MATERIAL_TABLE + " MAT"
						+ "WHERE PROJECT_ID = ?";
		// @formatter:on

		try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
			setParameter(stmt,1,projectId, Integer.class);
			try (ResultSet rs = stmt.executeQuery()){
				List<Material> mat = new LinkedList<>();
				while (rs.next()) {
					mat.add(extract(rs, Material.class));
				}
				return mat;
			}
		}
	}
	
	private List<Step> fetchStepsForProject(Connection con, Integer projectId) throws SQLException{
		// @formatter:off
		String selectSQL = ""
				+ "SELECT STEP.* " 
				+ "FROM " + STEP_TABLE + " STEP"
				+ "WHERE PROJECT_ID = ?";
		// @formatter:on

		try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
			setParameter(stmt,1,projectId, Integer.class);
			try (ResultSet rs = stmt.executeQuery()){
				List<Step> step = new LinkedList<>();
				while (rs.next()) {
					step.add(extract(rs, Step.class));
				}
				return step;
			}
		}
	}
	
	private List<Category> fetchCategoriesForProject(Connection con, Integer projectId) throws SQLException{
		// @formatter:off
		String selectSQL = ""
				+ "SELECT CAT.* " 
				+ "FROM " + CATEGORY_TABLE + " CAT"
				+ "INNER JOIN " + PROJECT_CATEGORY + " PC ON CAT.CATEGORY_ID = PC.CATEGORY_ID "
				+ "WHERE PROJECT_ID = ?";
		// @formatter:on
		
		try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
			setParameter(stmt,1,projectId, Integer.class);
			try (ResultSet rs = stmt.executeQuery()){
				List<Category> cat = new LinkedList<>();
				while (rs.next()) {
					cat.add(extract(rs, Category.class));
				}
				return cat;
			}
		}
	}
}
