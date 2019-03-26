package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT A.*, B.NAME AS DEPNAME "
					+ "FROM DESENV.SELLER A, DESENV.DEPARTMENT B "
					+ "WHERE A.DEPARTMENTID = B.ID AND A.ID = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return instantiateSeller(rs, dep);
			}
			return null;
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DEPARTMENTID"));
		dep.setName(rs.getString("DEPNAME"));		
		return dep;
	}	
	
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("ID"));
		seller.setName(rs.getString("NAME"));
		seller.setEmail(rs.getString("EMAIL"));
		seller.setBaseSalary(rs.getDouble("BASESALARY"));
		seller.setBirthDate(rs.getDate("BIRTHDATE"));
		seller.setDepartment(dep);
		return seller;
	}
}
