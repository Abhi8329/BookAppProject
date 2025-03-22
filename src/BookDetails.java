
public class BookDetails implements Comparable<BookDetails> {
	

	// fields 
	private int bookId;
	private float price ; 
	private String bookName , authorName ,publishDate;
	
	//setter & getter methods 
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	//parameterized Constructor
	public BookDetails(int bookId , float price, String bookName, String authorName, String publishDate) {
		super();
		this.bookId = bookId;
		this.price = price;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishDate = publishDate;
	}
	
	//constructor
	public BookDetails() {
		super();
	}
	
	//String methods
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId +", price=" + price + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", publishDate=" + publishDate + "]";
	}
	//comparable method extraction
	@Override
	public int compareTo(BookDetails b1) {
		// TODO Auto-generated method stub
		return Integer.compare(this.bookId, b1.bookId);
	}
	
}
