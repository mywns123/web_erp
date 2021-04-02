package web_erp.dto;

public class Title {
	private int No;
	private String Name;

	public Title() {}

	public Title(int no) {		
		No = no;
	}

	public Title(int no, String name) {
		super();
		No = no;
		Name = name;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + No;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (No != other.No)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Title [No=" + No + ", Name=" + Name + "]";
	}
	

	
}
