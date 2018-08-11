package br.edu.unifacear.session;

public class Login {
	private long matricula;
	private String senha;
	
	public Login() {}
	public Login(long matricula, String senha) {
		super();
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean Logar(long mat, String senha) {
		boolean acesso = false;
		
		FuncionarioSession session = new FuncionarioSession();
		
		acesso = session.Login(mat, senha);
		
		return acesso;
	}
}
