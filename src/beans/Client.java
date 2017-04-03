package beans;
import java.io.Serializable;


public class Client implements Serializable {

		private String username;
		private String passeword;
		
		public Client(String username, String pwd) {
			super();
			this.username = username;
			this.passeword = pwd;
		}

		// accessors and modifiers
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasseword() {
			return passeword;
		}

		public void setPasseword(String pwd) throws Exception {
			if(pwd.length()<10)
				throw new Exception("Erreur : longeur de mot de passe <4");
			else
				this.passeword = pwd;
		}

}
