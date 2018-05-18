package laskuri.model.dao;

import laskuri.model.dao.DataAccessObject;
import laskuri.model1.Opiskelija;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpiskelijaDAO extends DataAccessObject {
	public void addOpiskelija(Opiskelija opiskelija) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			// Luodaan uusi opiskelija tietokantaan:
			String sqlInsert = "INSERT INTO opiskelija(id, brutto, netto, opintotuki) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, opiskelija.getId());
			stmtInsert.setDouble(2, opiskelija.getBrutto());
			stmtInsert.setDouble(3, opiskelija.getNetto());
			stmtInsert.setDouble(4, opiskelija.getOpintotuki());
			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

	// Luodaan yhteys tietokantaan, josta poistetaan tiedot sql-komennolla
	// attribuutin ID:n perusteella
	public void removeTiedot(int opiskelijaId) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {

			connection = getConnection();
			String sqlInsert = "DELETE FROM opiskelija WHERE id = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, opiskelijaId);
			stmtDelete.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection);
		}
	}

	/*
	 * Lasketaan bruttopalkat yhteen opiskelija taulusta sql-komennolla, palauttaa bruttopalkat
	 * doublena
	 */
	public double getTotalBrutto() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		double totalBrutto = 0;
		try {
			conn = getConnection();
			String sqlSelect = "SELECT sum(Brutto) as bruttopalkka FROM opiskelija;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			while (rs.next()) {
				totalBrutto = rs.getDouble("bruttopalkka");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn);
		}
		return totalBrutto;

	}
	/*
	 * Lasketaan nettopalkat yhteen opiskelija taulusta sql-komennolla, palauttaa bruttopalkat
	 * doublena
	 */
	public double getTotalNetto() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		double totalNetto = 0;
		try {
			conn = getConnection();
			String sqlSelect = "SELECT sum(Netto) as nettopalkka FROM opiskelija;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			while (rs.next()) {
				totalNetto = rs.getDouble("nettopalkka");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn);
		}
		return totalNetto;
		
	}
	/*
	 * Lasketaan opintotukien m‰‰r‰ kuukausina yhteen opiskelija taulusta sql-komennolla, palauttaa opintotukikuukausien m‰‰r‰n
	 * 
	 */
	
	public double getTotalOpintotuki() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		double totalOpintotuki = 0;
		try {
			conn = getConnection();
			String sqlSelect = "SELECT Opintotuki, COUNT(Opintotuki) AS Maara FROM opiskelija GROUP BY Opintotuki;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			while (rs.next()) {
				totalOpintotuki = rs.getInt("Maara");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn);
		}
		return totalOpintotuki;
	}

	/**
	 * Hakee tietokannan taulusta kaikki palkkatiedot ja luo ja palauttaa tiedot
	 * Opiskelija-tyyppisten olioiden listana (ArrayList)
	 * 
	 * @return ArrayList<Henkilo> Lista opiskelijan palkoista
	 */

	public ArrayList<Opiskelija> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Opiskelija> palkat = new ArrayList<Opiskelija>();
		Opiskelija opiskelija = null;
		try {

			conn = getConnection();
			String sqlSelect = "SELECT id, Brutto, Netto, Opintotuki FROM opiskelija;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			while (rs.next()) {
				opiskelija = readOpiskelija(rs);
				palkat.add(opiskelija);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn);
		}
		System.out.println(palkat);
		return palkat;
	}

	private Opiskelija readOpiskelija(ResultSet rs) {
		try {
			// Haetaan  palkkatiedot kyselyn tulostaulun
			// (ResultSet-tyyppinen rs-olion) aktiiviselta tietorivilta
			int id = rs.getInt("id");
			double brutto = rs.getDouble("brutto");
			double netto = rs.getDouble("netto");
			double opintotuki = rs.getDouble("opintotuki");

			// Luodaan ja palautetaan uuden opiskelijan tiedot
			return new Opiskelija(id, brutto, netto, opintotuki);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

