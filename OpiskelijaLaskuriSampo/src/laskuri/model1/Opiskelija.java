package laskuri.model1;

public class Opiskelija {
	private int id;
	private Double netto;
	private Double brutto;
	private Double opintotuki;
	

	public Opiskelija() {
		super();
	}

	public Opiskelija(int id, Double brutto, Double netto, Double opintotuki) {
		this.id = id;
		this.netto = netto;
		this.brutto = brutto;
		this.opintotuki = opintotuki;

	}

	public Double getOpintotuki() {
		return opintotuki;
	}

	public void setOpintotuki(Double opintotuki) {
		this.opintotuki = opintotuki;
	}

	public int getId() {
		return id;
	}

	public Double getNetto() {
		return netto;
	}


	public void setNetto(Double netto) {
		this.netto = netto;
	}

	public Double getBrutto() {
		return brutto;
	}

	public void setBrutto(Double brutto) {
		this.brutto = brutto;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Opiskelija [id=" + id + ", netto=" + netto + ", brutto=" + brutto + ", opintotuki=" + opintotuki + "]";
	}
}
