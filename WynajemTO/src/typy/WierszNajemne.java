package typy;

public class WierszNajemne {
	private int id;
	private String data;
	private String opis;
	private String terminPlatnosci;
	private double kwota;
	private boolean stan;
	private String dataOplacenia = "";
	
	public WierszNajemne(){}
	
	public WierszNajemne(int id, String data, String opis, String terminPlatnosci, Double kwota, boolean stan, String dataOplacenia){
		this.id = id;
		this.data = data;
		this.opis = opis;
		this.terminPlatnosci = terminPlatnosci;
		this.kwota = kwota;
		this.stan = stan;
		this.dataOplacenia = dataOplacenia;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getTerminPlatnosci(){
		return terminPlatnosci;
	}
	public void setTerminPlatnosci(String terminPlatnosci){
		this.terminPlatnosci = terminPlatnosci;
	}
	public Double getKwota() {
		return kwota;
	}
	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}
	public boolean getStan() {
		return stan;
	}
	public void setStan(boolean stan) {
		this.stan = stan;
	}
	public String getDataOplacenia() {
		return dataOplacenia;
	}
	public void setDataOplacenia(String dataOplacenia) {
		this.dataOplacenia = dataOplacenia;
	}
	
	
}
