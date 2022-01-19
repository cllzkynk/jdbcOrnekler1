package techproed.jdbcOrnekler;

public class Urun {

	public Urun() {

	}

	public Urun(int id, String isim, double fiyat) {
		super();
		this.id = id;
		this.isim = isim;
		this.fiyat = fiyat;
	}

	private int id;
	private String isim;
	private double fiyat;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the isim
	 */
	public String getIsim() {
		return isim;
	}

	/**
	 * @param isim the isim to set
	 */
	public void setIsim(String isim) {
		this.isim = isim;
	}

	/**
	 * @return the fiyat
	 */
	public double getFiyat() {
		return fiyat;
	}

	/**
	 * @param fiyat the fiyat to set
	 */
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	@Override
	public String toString() {
		return "Urun [id=" + id + ", " + (isim != null ? "isim=" + isim + ", " : "") + "fiyat=" + fiyat + "]";
	}

}
