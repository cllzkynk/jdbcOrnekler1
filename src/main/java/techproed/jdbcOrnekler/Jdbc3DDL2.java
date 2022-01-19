package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc3DDL2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");
		Statement st = con.createStatement();

		/*
		 * =======================================================================
		 * ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') ekleyelim
		 * ========================================================================
		 */

//		int s1 = st.executeUpdate(" INSERT INTO bolumler VALUES(91, 'ARGE2','CORLU')");
//		System.out.println(s1 + " " + "bir satir eklendi");

		/*
		 * =======================================================================
		 * ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
		 * ========================================================================
		 */

		// 1.YONTEM
		// -----------------------------------------------
		// Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin
		// yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
		// bu kotu bir yaklasimdir.

//		         String[] sorgular = { "INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
//			"INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')", "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')" };

//		int count = 0;
//		for (String each : sorgular) {

//			count = count + st.executeUpdate(each);
//		}
//		System.out.println(count + "  satir  eklendi");

		// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
		// ----------------------------------------------------
		// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
		// metodu ile veritabanina bir kere gonderilebilir.
		// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade
		// sonucunda
		// etkilenen satir sayisini gosterir.

		String[] sorgular1 = { "INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
				"INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
				"INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')" };

		for (String each : sorgular1) {
			st.addBatch(each);
		}
		st.executeBatch();

	}
}
