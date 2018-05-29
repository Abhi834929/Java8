package edu.Java8.training.pojos;

public class Book  {
	
	private long bookNumber;
	private String  bookName;
	private double ratePerUnit;
	private String publisher;
	private Author author;
	
	public Book(long bookNumber, String bookName, double ratePerUnit, String publisher, Author author) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.ratePerUnit = ratePerUnit;
		this.publisher = publisher;
		this.author = author;
	}
	public Book(long bookNumber, String bookName, double ratePerUnit, String publisher) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.ratePerUnit = ratePerUnit;
		this.publisher = publisher;
	}
	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", ratePerUnit=" + ratePerUnit
				+ ", publisher=" + publisher + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + (int) (bookNumber ^ (bookNumber >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookNumber != other.bookNumber)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double.doubleToLongBits(other.ratePerUnit))
			return false;
		return true;
	}

	
	
}
