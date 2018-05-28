package edu.Java8.training.pojos;

public class Author {

	private  long authorCode;
	private  String authorName;
	private  String email;
	
	public Author(long authorCode, String authorName, String email) {
		super();
		this.authorCode = authorCode;
		this.authorName = authorName;
		this.email = email;
	}
	

	public long getAuthorCode() {
		return authorCode;
	}
	public void setAuthorCode(long authorCode) {
		this.authorCode = authorCode;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Author [authorCode=" + authorCode + ", authorName=" + authorName + ", email=" + email + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (authorCode ^ (authorCode >>> 32));
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Author other = (Author) obj;
		if (authorCode != other.authorCode)
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
