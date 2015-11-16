package typy;

	public class WierszOplaty {
		private int id;
		private String data;
		private String opis;
		private String terminPlatnosci;
		private String nrFaktury;
		private double kwota;
		private boolean stanAdministrator;
		private String dataOplaceniaAdministrator = "";
		private boolean stanWynajmujacy;
		private String dataOplaceniaWynajmujacy = "";
		
		public WierszOplaty(){}
		
		public WierszOplaty(int id, String data, String opis, String terminPlatnosci, String nrFaktury, double kwota,
				boolean stanAdministrator, String dataOplaceniaAdministrator, boolean stanWynajmujacy,
				String dataOplaceniaWynajmujacy){
			this.id = id;
			this.data = data;
			this.opis = opis;
			this.terminPlatnosci = terminPlatnosci;
			this.nrFaktury = nrFaktury;
			this.kwota = kwota;
			this.stanAdministrator = stanAdministrator;
			this.dataOplaceniaAdministrator = dataOplaceniaAdministrator;
			this.stanWynajmujacy = stanWynajmujacy;
			this.dataOplaceniaWynajmujacy = dataOplaceniaWynajmujacy;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
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
		public String getNrFaktury() {
			return nrFaktury;
		}
		public void setNrFaktury(String nrFaktury) {
			this.nrFaktury = nrFaktury;
		}
		public double getKwota() {
			return kwota;
		}
		public void setKwota(double kwota) {
			this.kwota = kwota;
		}
		public boolean getStanAdministrator() {
			return stanAdministrator;
		}
		public void setStanAdministrator(boolean stanAdministrator) {
			this.stanAdministrator = stanAdministrator;
		}
		public String getDataOplaceniaAdministrator() {
			return dataOplaceniaAdministrator;
		}
		public void setDataOplaceniaAdministrator(String dataOplaceniaAdministrator) {
			this.dataOplaceniaAdministrator = dataOplaceniaAdministrator;
		}
		public boolean getStanWynajmujacy() {
			return stanWynajmujacy;
		}
		public void setStanWynajmujacy(boolean stanWynajmujacy) {
			this.stanWynajmujacy = stanWynajmujacy;
		}
		public String getDataOplaceniaWynajmujacy() {
			return dataOplaceniaWynajmujacy;
		}
		public void setDataOplaceniaWynajmujacy(String dataOplaceniaWynajmujacy) {
			this.dataOplaceniaWynajmujacy = dataOplaceniaWynajmujacy;
		}		

}
