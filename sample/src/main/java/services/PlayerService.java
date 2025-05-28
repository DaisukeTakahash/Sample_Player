package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Player;
import utils.Db;

public class PlayerService {
//	private Connection conn;
//	public PlayerService(Connection conn) {
//		this.conn = conn;
//	}
	
	public ArrayList<Player> select() {
	String sql = "SELECT id, country_id, uniform_num, position, name, club, birth, height, weight FROM players";
	ArrayList<Player> players = new ArrayList<>();
	
	try (
			Connection conn = Db.open();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		) {
		while(rs.next()) {
			int id = rs.getInt("id");
			int country_id = rs.getInt("country_id");
			int uniform_num = rs.getInt("uniform_num");
			String position = rs.getString("position");
			String name = rs.getString("name");
			String club = rs.getString("club");
			Date birth = rs.getDate("birth");
			double height = rs.getDouble("height");
			double weight = rs.getDouble("weight");
			
			players.add(new Player(id, country_id, uniform_num, position, name, club, birth.toLocalDate(), height, weight));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return players;
}
	public int insert(Player p) {
		String sql = "INSERT INTO players (country_id, uniform_num, position, name, club, birth, height, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int id = 0;
		
		try (
			Connection conn = Db.open();
				java.sql.PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setInt(1, p.getCountry_id());
			ps.setInt(2, p.getUniform_num());
			ps.setString(3, p.getPosition());
			ps.setString(4, p.getName());
			ps.setString(5, p.getClub());
			ps.setDate(6, java.sql.Date.valueOf(p.getBirth()));
			ps.setDouble(7, p.getHeight());
			ps.setDouble(8, p.getWeight());

			id = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}
	public void update(Player p) {
		String sql = "UPDATE players SET country_id = ?, uniform_num = ?, position = ?, name = ?, club = ?, birth = ?, height = ?, weight = ? WHERE id = ?";

		try (
			Connection conn = Db.open();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
				) {
			ps.setInt(1, p.getCountry_id());
			ps.setInt(2, p.getUniform_num());
			ps.setString(3, p.getPosition());
			ps.setString(4, p.getName());
			ps.setString(5, p.getClub());
			ps.setDate(6, java.sql.Date.valueOf(p.getBirth()));
			ps.setDouble(7, p.getHeight());
			ps.setDouble(8, p.getWeight());
			ps.setInt(9, p.getId()); 

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void delete(int id) {
		String sql = "DELETE FROM players WHERE id = ?";
		
		try (
			Connection conn = Db.open();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);	
				) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

